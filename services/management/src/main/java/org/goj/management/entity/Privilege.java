package org.goj.management.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限授予
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户帐号
     */
    private Long userId;

    /**
     * 分组
     */
    private String rightstr;

    /**
     * 是否屏蔽
     */
    private String defunct;


}
