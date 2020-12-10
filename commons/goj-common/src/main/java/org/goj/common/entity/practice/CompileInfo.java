package org.goj.common.entity.practice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 编译错误的记录
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CompileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提交id
     */
    @TableId(value = "solution_id", type = IdType.ASSIGN_ID)
    private Long solutionId;

    /**
     * 编译错误原因
     */
    private String error;


}
