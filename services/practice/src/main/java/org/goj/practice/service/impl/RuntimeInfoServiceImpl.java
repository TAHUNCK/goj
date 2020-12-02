package org.goj.practice.service.impl;

import org.goj.practice.entity.RuntimeInfo;
import org.goj.practice.mapper.RuntimeInfoMapper;
import org.goj.practice.service.RuntimeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 运行错误信息 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class RuntimeInfoServiceImpl extends ServiceImpl<RuntimeInfoMapper, RuntimeInfo> implements RuntimeInfoService {

}
