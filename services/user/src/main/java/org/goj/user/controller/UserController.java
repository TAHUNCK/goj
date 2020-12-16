package org.goj.user.controller;

import cn.hutool.core.util.RandomUtil;
import org.goj.common.constant.CommonConstant;
import org.goj.common.constant.RedisConstant;
import org.goj.common.constant.ResultCode;
import org.goj.common.entity.base.Email;
import org.goj.common.model.Result;
import org.goj.feign.feign.BaseFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
            return Result.succeed(ResultCode.ERROR_VERIFICATION_CODE_K0003.getCode(),"验证码未过期，请稍后再试！");
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
