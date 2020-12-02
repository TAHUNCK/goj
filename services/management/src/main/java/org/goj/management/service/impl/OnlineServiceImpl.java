package org.goj.management.service.impl;

import org.goj.management.entity.Online;
import org.goj.management.mapper.OnlineMapper;
import org.goj.management.service.OnlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户在线数据统计 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class OnlineServiceImpl extends ServiceImpl<OnlineMapper, Online> implements OnlineService {

}
