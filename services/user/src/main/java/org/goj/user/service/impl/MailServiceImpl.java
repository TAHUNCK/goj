package org.goj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.Mail;
import org.goj.user.mapper.MailMapper;
import org.goj.user.service.MailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息列表 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements MailService {

}
