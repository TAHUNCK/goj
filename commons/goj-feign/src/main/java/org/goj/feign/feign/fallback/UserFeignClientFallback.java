package org.goj.feign.feign.fallback;

import org.goj.common.entity.auth.LoginUser;
import org.goj.feign.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author CK
 * @date 2021/1/31 13:12
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public LoginUser findByLoginUser(String email) {
        return null;
    }

    @Override
    public Boolean initResourceRolesMap() {
        return false;
    }
}
