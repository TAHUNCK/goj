package org.goj.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.goj.common.entity.user.Classify;
import org.goj.practice.vo.ClassifyCascaderVO;

import java.util.List;

/**
 * <p>
 * 题目分类 服务类
 * </p>
 *
 * @author CK
 * @since 2020-12-07
 */
public interface ClassifyService extends IService<Classify> {

    /**
     * 级联查询所有分类信息
     *
     * @return List<ClassifyCascaderVO>
     * @author CK
     * @date 2020/12/7 17:43
     */
    List<ClassifyCascaderVO> listClassifyCascader();

}
