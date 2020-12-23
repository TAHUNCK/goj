package org.goj.user.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.goj.common.constant.CommonConstant;
import org.goj.common.constant.RedisConstant;
import org.goj.common.constant.ResultCode;
import org.goj.common.entity.auth.LoginUser;
import org.goj.common.entity.auth.Oauth2TokenDTO;
import org.goj.common.entity.base.Email;
import org.goj.common.entity.user.Role;
import org.goj.common.entity.user.User;
import org.goj.common.model.Result;
import org.goj.feign.feign.AuthFeignClient;
import org.goj.feign.feign.BaseFeignClient;
import org.goj.user.mapper.RoleMapper;
import org.goj.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private BaseFeignClient baseFeignClient;

    @Resource
    private UserService userService;

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private AuthFeignClient authFeignClient;

    /**
     * 用户登录
     *
     * @param email 邮箱
     * @param password 密码
     * @return Result<Oauth2TokenDTO>
     * @author CK
     * @date 2020/12/17 11:36
     */
    @PostMapping("/login")
    Result<Oauth2TokenDTO> loginToGetToken(@RequestParam(value = "email")String email,
                                           @RequestParam(value = "password")String password){
        Map<String, String> parameters = Map.of("grant_type", "password", "client_id", "GojPassword", "client_secret", "GojSecretPassword", "username", email, "password", password);
        User user = new LoginUser();
        user.setUsername("GojPassword");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null);
        Result<Oauth2TokenDTO> result = authFeignClient.postAccessToken(token, parameters);
        Assert.isTrue(result.getCode().equals(ResultCode.SUCCESS.getCode()), result.getMessage());
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.select("head_portrait").eq(StrUtil.isNotBlank(email),"email",email);
        List<User> list=userService.list(userQueryWrapper);
        Oauth2TokenDTO oauth2TokenDTO=result.getData();
        oauth2TokenDTO.setHeadPortrait(list.get(0).getHeadPortrait());
        return Result.succeed("登录成功！", result.getData());
    }

    /**
     * 用户注册
     *
     * @param email 邮箱
     * @param password 密码
     * @param rePassword 重复密码
     * @param captcha 验证码
     * @return Result<Oauth2TokenDTO>
     * @author CK
     * @date 2020/12/17 11:36
     */
    @PostMapping("/register")
    Result<Oauth2TokenDTO> registerToGetToken(@RequestParam(value = "email")String email,
                                              @RequestParam(value = "password")String password,
                                              @RequestParam(value = "rePassword")String rePassword,
                                              @RequestParam(value = "captcha")String captcha){
        Assert.isTrue(password.equals(rePassword)&&StrUtil.isNotBlank(password),"两次输入密码不相等！");
        String redisCode= (String) redisTemplate.opsForValue().get(RedisConstant.EMAIL_VALIDATE_CODE + email);
        Assert.notNull(redisCode,"验证码不存在或已过期！");
        Assert.isTrue(redisCode.equals(captcha),"验证码输入错误！");
        boolean f=userService.insertUserAndUserRole(email,password);
        Assert.isTrue(f,"注册失败！");
        Result<Oauth2TokenDTO> oauth2TokenResult=loginToGetToken(email,password);
        return Result.succeed("注册成功,自动登录！",oauth2TokenResult.getData());
    }

    @GetMapping(value = "/getUserByEmail")
    LoginUser findByLoginUser(@RequestParam(value = "email") String email){
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq(StrUtil.isNotBlank(email),"email",email);
        List<User> users=userService.list(userQueryWrapper);
        Assert.isTrue(users.size()==1,"查询邮箱不唯一！");
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(users.get(0), loginUser);
        List<Role> roles = roleMapper.getRoleByUser(users.get(0).getUserId());
        loginUser.setRoles(roles);
        return loginUser;
    }

    /**
     * 发送验证码给用户邮箱
     *
     * @param to 用户邮箱
     * @return Result<String>
     * @author CK
     * @date 2020/12/15 20:29
     */
    @PostMapping("/userEmail")
    public Result<String> sendSimpleEmail(@RequestParam(value = "to") String to){
        if (!StringUtils.isEmpty(redisTemplate.opsForValue().get(RedisConstant.EMAIL_VALIDATE_CODE + to))) {
            return Result.succeed(ResultCode.ERROR_VERIFICATION_CODE_K0003.getCode(),ResultCode.ERROR_VERIFICATION_CODE_K0003.getMessage());
        }
        String code = RandomUtil.randomString(CommonConstant.BASE_STRING, 6);
        Email email=new Email();
        email.setTo(to);
        email.setSubject("GOJ邮箱验证码");
        email.setContent("您的验证码为：" + code + "，请于2分钟内使用。如非本人操作，请忽略本邮件。");
        baseFeignClient.sendSimpleEmail(email);
        redisTemplate.opsForValue().set(RedisConstant.EMAIL_VALIDATE_CODE+email.getTo(),code,120, TimeUnit.SECONDS);
        return Result.succeed("发送邮件成功！");
    }

}
