package org.goj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.Role;
import org.goj.user.mapper.RoleMapper;
import org.goj.user.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限授予 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
