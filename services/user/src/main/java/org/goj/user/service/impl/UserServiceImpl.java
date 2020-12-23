package org.goj.user.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.User;
import org.goj.common.entity.user.UserRole;
import org.goj.user.mapper.UserMapper;
import org.goj.user.mapper.UserRoleMapper;
import org.goj.user.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUserAndUserRole(String email,String password) {
        User user=new User();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        user.setEmail(email).setPassword(passwordEncoder.encode(password)).setDefunct("N").setIp(request.getRemoteAddr())
                .setRegTime(new Date()).setAccessTime(new Date()).setNick("无名").setHeadPortrait("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        super.save(user);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("email", email);
        List<User> userList = super.list(userQueryWrapper);
        Assert.isTrue(userList.size() == 1, "查询邮箱不唯一！");
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setUserId(userList.get(0).getUserId());
        int a= userRoleMapper.insert(userRole);
        Assert.isTrue(a==1,"添加用户失败！");
        return true;
    }
}
