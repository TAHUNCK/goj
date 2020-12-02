package org.goj.practice.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 竞赛题目
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContestProblem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    private Long contestProblemId;

    /**
     * 竞赛id
     */
    private Long contestId;

    /**
     * 标题
     */
    private String title;

    /**
     * 竞赛题目编号
     */
    private Integer num;

    private Integer contestAccepted;

    private Integer contestSubmit;


}
