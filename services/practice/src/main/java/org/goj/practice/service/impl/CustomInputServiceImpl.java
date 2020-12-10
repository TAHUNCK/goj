package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.CustomInput;
import org.goj.practice.mapper.CustomInputMapper;
import org.goj.practice.service.CustomInputService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 在线IDE 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class CustomInputServiceImpl extends ServiceImpl<CustomInputMapper, CustomInput> implements CustomInputService {

}
