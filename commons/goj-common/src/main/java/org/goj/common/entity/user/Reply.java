package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 论坛（帖子及回复）
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子序号
     */
    @TableId(value = "reply_id", type = IdType.ASSIGN_ID)
    private Long replyId;

    /**
     * 作者帐号
     */
    private Long authorId;

    /**
     * 发布时间
     */
    private Date time;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 帖子分组
     */
    private Long topicId;

    /**
     * 状态（0：正常，1：锁定，2：删除）
     */
    private Integer status;

    /**
     * 发帖子者ip
     */
    private String ip;


}
