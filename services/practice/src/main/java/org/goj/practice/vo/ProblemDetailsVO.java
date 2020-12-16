package org.goj.practice.vo;

import lombok.Data;

/**
 * @author CK
 * @date 2020/12/14 17:13
 */
@Data
public class ProblemDetailsVO {

    private Long problemId;

    private String title;

    private String description;

    private String input;

    private String output;

    private String sampleInput;

    private String sampleOutput;

    private Integer timeLimit;

    private Integer memoryLimit;

    private String hint;

}
