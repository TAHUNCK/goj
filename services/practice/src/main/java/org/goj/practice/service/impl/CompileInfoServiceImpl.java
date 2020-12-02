package org.goj.practice.service.impl;

import org.goj.practice.entity.CompileInfo;
import org.goj.practice.mapper.CompileInfoMapper;
import org.goj.practice.service.CompileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
