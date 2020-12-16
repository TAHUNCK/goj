package org.goj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.Reply;
import org.goj.user.mapper.ReplyMapper;
import org.goj.user.service.ReplyService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛（帖子及回复） 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

}
