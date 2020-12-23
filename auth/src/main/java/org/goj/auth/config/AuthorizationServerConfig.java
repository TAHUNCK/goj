package org.goj.auth.config;

import org.goj.auth.service.UserDetailsServiceImpl;
import org.goj.common.constant.AuthConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * OAuth2 认证服务器配置
 *
 * @author CK
 * @date 2020/10/24 16:25
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 注入authenticationManager 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 从证书中获取密钥对
     *
     * @author CK
     * @date 2020/11/15 9:45
     */
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenStore tokenStore;

    /**
     * 添加一些额外的信息至Token
     *
     * @author CK
     * @date 2020/11/15 9:45
     */
    @Autowired
    private TokenEnhancer tokenEnhancer;

    /**
     * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     *
     * @author CK
     * @date 2020/11/15 11:18
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients();
    }

    /**
     * 配置OAuth2客户端信息存入内存
     * 使用密码模式，且Token刷新
     *
     * @param clients OAuth2客户端信息
     * @return void
     * @author CK
     * @date 2020/11/3 18:13
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //密码模式
                .withClient("GojPassword")
                .secret(passwordEncoder.encode("GojSecretPassword"))
                .scopes("all")
                .authorizedGrantTypes(AuthConstant.PASSWORD, AuthConstant.REFRESH_TOKEN)
                .accessTokenValiditySeconds(864000)
                .refreshTokenValiditySeconds(864000);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //JWT内容增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer, jwtAccessTokenConverter));

        endpoints.tokenEnhancer(tokenEnhancerChain)
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                .authenticationManager(authenticationManager)
                //加载用户信息
                .userDetailsService(userDetailsService);
    }

}
