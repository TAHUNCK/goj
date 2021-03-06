package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.Solution;
import org.goj.practice.mapper.SolutionMapper;
import org.goj.practice.service.SolutionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 程序运行结果记录 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class SolutionServiceImpl extends ServiceImpl<SolutionMapper, Solution> implements SolutionService {

}
