package org.goj.management.service.impl;

import org.goj.management.entity.Sim;
import org.goj.management.mapper.SimMapper;
import org.goj.management.service.SimService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相似度检测表 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class SimServiceImpl extends ServiceImpl<SimMapper, Sim> implements SimService {

}
