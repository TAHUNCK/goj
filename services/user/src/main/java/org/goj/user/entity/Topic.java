package org.goj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 论坛帖子表
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子编号
     */
    @TableId(value = "topic_id", type = IdType.ASSIGN_ID)
    private Long topicId;

    /**
     * 标题
     */
    private byte[] title;

    /**
     * 状态（0：未锁定，1：锁定）
     */
    private Integer status;

    /**
     * 置顶等级（0，1：题目置顶，2：分区置顶，3：总置顶）
     */
    private Integer topLevel;

    /**
     * 竞赛编号
     */
    private Long contestId;

    /**
     * 竞赛中题目编号
     */
    private Long contestProblemId;

    /**
     * 作者id
     */
    private String authorId;


}
