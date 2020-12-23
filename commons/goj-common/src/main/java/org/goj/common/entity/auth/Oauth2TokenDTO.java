package org.goj.common.entity.auth;

import lombok.Data;

/**
 * @author CK
 * @date 2020/12/16 19:59
 */
@Data
public class Oauth2TokenDTO {

    public Oauth2TokenDTO(){}

    /**
     * 访问令牌
     */
    private String token;
    /**
     * 访问令牌头前缀
     */
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    private Integer expiresIn;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户头像
     */
    private String headPortrait;
}

