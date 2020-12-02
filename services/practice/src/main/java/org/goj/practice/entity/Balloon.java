package org.goj.practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 气球
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Balloon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "balloon_id", type = IdType.ASSIGN_ID)
    private Long balloonId;

    private Long userId;

    private Long sid;

    private Long contestId;

    private Long contestProblemId;

    private Integer status;


}
