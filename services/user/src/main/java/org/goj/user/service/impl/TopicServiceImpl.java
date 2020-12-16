package org.goj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.Topic;
import org.goj.user.mapper.TopicMapper;
import org.goj.user.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛帖子表 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

}
