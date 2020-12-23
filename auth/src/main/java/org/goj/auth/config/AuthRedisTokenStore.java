package org.goj.auth.config;

import org.goj.common.constant.AuthConstant;
import org.goj.common.entity.auth.LoginUser;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证服务器生成令牌
 *
 * @author CK
 * @date 2020/10/24 17:25
 */
@Configuration
public class AuthRedisTokenStore {

    @Bean("keyProp")
    public KeyProperties keyProperties() {
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    /**
     * 从证书中获取密钥对
     *
     * @author CK
     * @date 2020/11/15 9:34
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(KeyPair keyPair) {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Bean
    public KeyPair keyPair(){
        return new KeyStoreKeyFactory(
                keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getSecret().toCharArray())
                .getKeyPair(keyProperties.getKeyStore().getAlias());
    }

    /**
     * jwt 生成token 定制化处理
     * 添加一些额外的用户信息到token里面
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            LoginUser loginUser=(LoginUser)authentication.getPrincipal();
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            //将用户ID设置到JWT中
            additionalInfo.put(AuthConstant.USER_ID,loginUser.getUserId());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

}
