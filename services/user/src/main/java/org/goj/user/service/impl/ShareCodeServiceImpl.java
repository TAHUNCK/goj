package org.goj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.user.ShareCode;
import org.goj.user.mapper.ShareCodeMapper;
import org.goj.user.service.ShareCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代码分享 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class ShareCodeServiceImpl extends ServiceImpl<ShareCodeMapper, ShareCode> implements ShareCodeService {

}
