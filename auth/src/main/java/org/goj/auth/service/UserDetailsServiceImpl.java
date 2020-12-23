package org.goj.auth.service;

import org.goj.common.entity.auth.LoginUser;
import org.goj.feign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author CK
 * @date 2020/12/16 17:46
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginUser loginUser=userFeignClient.findByLoginUser(email);
        Assert.notNull(loginUser,"用户名或密码错误！");
        return loginUser;
    }
}
