package org.goj.practice.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author CK
 * @date 2020/12/7 17:37
 */
@Data
public class ClassifyCascaderVO implements Serializable {

    private Long value;

    private String label;

    private List<ClassifyCascaderVO> children;

}
