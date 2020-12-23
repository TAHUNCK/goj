package org.goj.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码工具，使用BCrypt加密
 *
 * @author CK
 * @date 2020/11/4 16:01
 */
@Configuration
public class DefaultPasswordConfig {

    /**
     * 装配BCryptPasswordEncoder用户密码的匹配
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
