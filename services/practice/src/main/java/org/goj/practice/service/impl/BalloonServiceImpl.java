package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.Balloon;
import org.goj.practice.mapper.BalloonMapper;
import org.goj.practice.service.BalloonService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 气球 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class BalloonServiceImpl extends ServiceImpl<BalloonMapper, Balloon> implements BalloonService {

}
