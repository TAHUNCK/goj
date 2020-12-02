package org.goj.practice.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 题目
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目编号
     */
    @TableId(value = "problem_id", type = IdType.ASSIGN_ID)
    private Long problemId;

    /**
     * 标题
     */
    private String title;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 输入说明
     */
    private String input;

    /**
     * 输出说明
     */
    private String output;

    /**
     * 输入参照
     */
    private String sampleInput;

    /**
     * 输出参照
     */
    private String sampleOutput;

    /**
     * 是否为特别题目
     */
    private String spj;

    /**
     * 暗示
     */
    private String hint;

    /**
     * 来源
     */
    private String source;

    /**
     * 加入时间
     */
    private Date inDate;

    /**
     * 限时（秒）
     */
    private BigDecimal timeLimit;

    /**
     * 空间限制(MByte)
     */
    private Integer memoryLimit;

    /**
     * 是否屏蔽
     */
    private String defunct;

    /**
     * 总ac次数
     */
    private Integer accepted;

    /**
     * 总提交次数
     */
    private Integer submit;

    /**
     * 解答
     */
    private Integer solved;

    /**
     * ac比例
     */
    private Integer ratio;


}
