package org.goj.practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 竞赛表
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Contest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 竞赛id
     */
    @TableId(value = "contest_id", type = IdType.ASSIGN_ID)
    private Long contestId;

    /**
     * 竞赛标题
     */
    private String title;

    /**
     * 开始时间(年月日时分)
     */
    private Date startTime;

    /**
     * 结束时间(年月日时分)
     */
    private Date endTime;

    /**
     * 是否屏蔽
     */
    private String defunct;

    /**
     * 描述
     */
    private String description;

    /**
     * 公开/内部
     */
    private Integer privilege;

    /**
     * 语言
     */
    private Integer language;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户id
     */
    private Long userId;


}
