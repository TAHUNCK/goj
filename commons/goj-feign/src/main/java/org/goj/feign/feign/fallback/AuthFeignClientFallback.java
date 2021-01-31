package org.goj.feign.feign.fallback;

import org.goj.common.entity.auth.Oauth2TokenDTO;
import org.goj.common.model.Result;
import org.goj.feign.feign.AuthFeignClient;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Map;

/**
 * @author CK
 * @date 2021/1/31 13:18
 */
@Component
public class AuthFeignClientFallback implements AuthFeignClient {
    @Override
    public Result<Oauth2TokenDTO> postAccessToken(Principal principal, Map<String, String> parameters) {
        return Result.failed("获取token失败！");
    }
}
