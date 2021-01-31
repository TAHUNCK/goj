package org.goj.feign.feign;

import org.goj.common.entity.auth.Oauth2TokenDTO;
import org.goj.common.model.Result;
import org.goj.feign.feign.fallback.AuthFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

/**
 * @author CK
 * @date 2020/12/17 10:25
 */
@Component("authFeignClient")
@FeignClient(name = "auth", fallback = AuthFeignClientFallback.class)
public interface AuthFeignClient {

    @PostMapping(value = "/oauth/token")
    Result<Oauth2TokenDTO> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters);

}
