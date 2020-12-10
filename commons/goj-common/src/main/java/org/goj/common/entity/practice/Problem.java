package org.goj.common.entity.practice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
     * 题目ID
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
    private Long classifyId;

    /**
     * 加入时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
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
    private Float ratio;

    /**
     * 题目编号
     */
    private Integer problemNum;


}
