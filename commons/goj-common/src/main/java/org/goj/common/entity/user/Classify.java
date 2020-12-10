package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 题目分类
 * </p>
 *
 * @author CK
 * @since 2020-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Classify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "classify_id", type = IdType.ASSIGN_ID)
    private Long classifyId;

    private Long classifyParentId;

    private String classifyName;


}
