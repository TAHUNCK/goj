package org.goj.practice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.goj.common.entity.practice.Problem;
import org.goj.practice.vo.ProblemVO;

/**
 * <p>
 * 题目 Mapper 接口
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
public interface ProblemMapper extends BaseMapper<Problem> {

    /**
     * 条件分页查询题目
     *
     * @param page 分页
     * @param queryWrapper 条件
     * @return Page<ProblemVO>
     * @author CK
     * @date 2020/12/9 10:41
     */
    Page<ProblemVO> getProblemConditionPage(Page<ProblemVO> page, @Param(Constants.WRAPPER) QueryWrapper<ProblemVO> queryWrapper);
}
