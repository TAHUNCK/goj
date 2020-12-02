package org.goj.management.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 登入日志
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录的ip
     */
    private String ip;

    /**
     * 登入时间
     */
    private Date time;


}
