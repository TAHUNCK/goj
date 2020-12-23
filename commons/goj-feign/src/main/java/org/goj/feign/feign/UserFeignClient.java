package org.goj.feign.feign;

import org.goj.common.entity.auth.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户RPC调用接口
 *
 * @author CK
 * @date 2020/12/16 17:50
 */
@FeignClient(name = "user")
public interface UserFeignClient {

    /**
     * feign rpc调用/user/getUserByEmail接口
     *
     * @param email 用户邮箱
     * @return LoginUser
     * @author CK
     * @date 2020/12/16 18:00
     */
    @GetMapping(value = "/user/getUserByEmail")
    LoginUser findByLoginUser(@RequestParam(value = "email") String email);

    /**
     * 初始化路径资源角色
     *
     * @return Boolean
     * @author CK
     * @date 2020/12/16 20:06
     */
    @GetMapping(value = "/resource/initResourceRolesMap")
    Boolean initResourceRolesMap();
}
