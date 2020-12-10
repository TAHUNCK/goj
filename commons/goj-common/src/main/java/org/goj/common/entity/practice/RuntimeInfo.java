package org.goj.common.entity.practice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 运行错误信息
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RuntimeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运行id
     */
    @TableId(value = "solution_id", type = IdType.ASSIGN_ID)
    private Long solutionId;

    /**
     * 错误记录
     */
    private String error;


}
