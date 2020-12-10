package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 代码分享
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShareCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "share_id", type = IdType.ASSIGN_ID)
    private Long shareId;

    private Long userId;

    private String shareCode;

    private String language;

    private Date shareTime;


}
