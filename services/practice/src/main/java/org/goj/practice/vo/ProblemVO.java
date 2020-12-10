package org.goj.practice.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CK
 * @date 2020/12/7 18:58
 */
@Data
public class ProblemVO implements Serializable {

    /**
     * 题目ID
     */
    private Long problemId;

    /**
     * 题目编号
     */
    private Integer problemNum;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 总ac次数
     */
    private Integer accepted;

    /**
     * 总提交次数
     */
    private Integer submit;

    /**
     * ac比例
     */
    private Float ratio;

}
