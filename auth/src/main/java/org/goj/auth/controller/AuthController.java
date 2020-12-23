package org.goj.auth.controller;

import org.goj.common.entity.auth.Oauth2TokenDTO;
import org.goj.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.util.Assert;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 *
 * @author CK
 * @date 2020/11/23 11:48
 */
@RestController
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * Oauth2登录认证
     */
    @PostMapping(value = "/oauth/token")
    public Result<Oauth2TokenDTO> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Assert.notNull(oAuth2AccessToken,"获取Token失败！");
        Oauth2TokenDTO oauth2TokenDTO = new Oauth2TokenDTO();
        oauth2TokenDTO.setToken("bearer "+oAuth2AccessToken.getValue());
        oauth2TokenDTO.setExpiresIn(oAuth2AccessToken.getExpiresIn());
        oauth2TokenDTO.setUserId((Long) oAuth2AccessToken.getAdditionalInformation().get("user_id"));
        return Result.succeed("获取Token成功",oauth2TokenDTO);
    }
}
