package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.SourceCode;
import org.goj.practice.mapper.SourceCodeMapper;
import org.goj.practice.service.SourceCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提交的源码 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class SourceCodeServiceImpl extends ServiceImpl<SourceCodeMapper, SourceCode> implements SourceCodeService {

}
