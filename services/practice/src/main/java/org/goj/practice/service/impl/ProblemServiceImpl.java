package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.Problem;
import org.goj.practice.mapper.ProblemMapper;
import org.goj.practice.service.ProblemService;
import org.goj.practice.vo.ProblemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

    @Resource
    private ProblemMapper problemMapper;

    @Override
    public Page<ProblemVO> getProblemConditionPage(Integer current, Integer size, List<Long> classifyIdList, Integer sort) {
        Map<Integer, String> sortMap = Map.of(1, "problem_num", 2, "problem_num", 3, "accepted", 4, "accepted",
                5, "submit", 6, "submit", 7, "ratio", 8, "ratio");
        Page<ProblemVO> page = new Page<>(current, size);
        QueryWrapper<ProblemVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(classifyIdList!=null,"classify.classify_id", classifyIdList)
                .orderBy(sort != 0, (sort & 1) == 1, sortMap.get(sort));
        return problemMapper.getProblemConditionPage(page, queryWrapper);
    }
}
