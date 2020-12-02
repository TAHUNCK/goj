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
 * 程序运行结果记录
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运行id
     */
    @TableId(value = "solution_id", type = IdType.ASSIGN_ID)
    private Long solutionId;

    /**
     * 问题id
     */
    private Long problemId;

    /**
     * 用户id
     */
    private Long userId;

    private String nick;

    /**
     * 用时（秒）
     */
    private Integer time;

    /**
     * 所用空间
     */
    private Integer memory;

    /**
     * 加入时间
     */
    private Date inDate;

    /**
     * 结果（4：AC）
     */
    private Integer result;

    /**
     * 语言
     */
    private Integer language;

    /**
     * 用户ip
     */
    private String ip;

    /**
     * 所属于竞赛组
     */
    private Long contestId;

    /**
     * 是否有效
     */
    private Integer valid;

    /**
     * 题目在竞赛中的顺序号
     */
    private Integer num;

    /**
     * 代码长度
     */
    private Integer codeLength;

    /**
     * 判题时间
     */
    private Date judgetime;

    /**
     * 通过百分比（OI模式下可用）
     */
    private BigDecimal passRate;

    private Integer lintError;

    private String judger;


}
