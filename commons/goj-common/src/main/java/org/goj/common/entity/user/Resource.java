package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @TableId(value = "resource_id", type = IdType.ASSIGN_ID)
    private Long resourceId;

    /**
     * 资源描述
     */
    private String resourceDesc;

    /**
     * 资源路径
     */
    private String resourceUrl;


}
