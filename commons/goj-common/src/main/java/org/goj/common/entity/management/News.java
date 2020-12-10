package org.goj.common.entity.management;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 新闻表
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻编号
     */
    @TableId(value = "news_id", type = IdType.ASSIGN_ID)
    private Long newsId;

    /**
     * 用户账号
     */
    private Long userId;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 更新时间
     */
    private Date time;

    /**
     * 关键字
     */
    private Integer importance;

    /**
     * 是否屏蔽
     */
    private String defunct;


}
