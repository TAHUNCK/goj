package org.goj.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 相似度检测表
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Sim implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提交编号
     */
    @TableId(value = "sim_id", type = IdType.ASSIGN_ID)
    private Long simId;

    /**
     * 与s_id相似
     */
    private Long simSId;

    /**
     * 相似度（50-100）
     */
    private Integer sim;


}
