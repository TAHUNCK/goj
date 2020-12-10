package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.CompileInfo;
import org.goj.practice.mapper.CompileInfoMapper;
import org.goj.practice.service.CompileInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 编译错误的记录 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class CompileInfoServiceImpl extends ServiceImpl<CompileInfoMapper, CompileInfo> implements CompileInfoService {

}
