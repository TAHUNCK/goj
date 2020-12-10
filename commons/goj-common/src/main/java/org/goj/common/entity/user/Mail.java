package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 消息列表
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息编号
     */
    @TableId(value = "mail_id", type = IdType.ASSIGN_ID)
    private Long mailId;

    /**
     * 接收者
     */
    private Long toUserId;

    /**
     * 发送者
     */
    private Long fromUserId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 新消息（1/0）
     */
    private Boolean newMail;

    /**
     * 回复
     */
    private Integer reply;

    /**
     * 时间
     */
    private Date inDate;

    /**
     * 是否屏蔽
     */
    private String defunct;


}
