package org.goj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.goj.common.entity.user.Resource;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 初始化路径资源映射角色
     *
     * @return Boolean
     * @author CK
     * @date 2020/12/16 20:08
     */
    Boolean initResourceRolesMap();

}
