package org.goj.practice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.goj.common.entity.practice.Problem;
import org.goj.practice.vo.ProblemVO;

import java.util.List;

/**
 * <p>
 * 题目 服务类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
public interface ProblemService extends IService<Problem> {

    /**
     * 条件分页查询题目
     *
     * @param current 当前页
     * @param size 页面大小
     * @param classifyIdList 分类集合
     * @param sort 排序条件
     * @return Page<ProblemVO>
     * @author CK
     * @date 2020/12/9 9:56
     */
    Page<ProblemVO> getProblemConditionPage(Integer current, Integer size, List<Long> classifyIdList, Integer sort);
}
