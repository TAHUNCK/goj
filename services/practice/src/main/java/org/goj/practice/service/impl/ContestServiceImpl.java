package org.goj.practice.service.impl;

import org.goj.practice.entity.Contest;
import org.goj.practice.mapper.ContestMapper;
import org.goj.practice.service.ContestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 竞赛表 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper, Contest> implements ContestService {

}
