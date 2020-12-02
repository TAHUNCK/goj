package org.goj.management.service.impl;

import org.goj.management.entity.LoginLog;
import org.goj.management.mapper.LoginLogMapper;
import org.goj.management.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登入日志 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
