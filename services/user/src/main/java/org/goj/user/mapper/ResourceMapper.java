package org.goj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.goj.common.entity.user.Resource;
import org.goj.common.entity.user.RoleResource;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 根据路径资源查询其对应的角色
     *
     * @param resourceUrl 资源路径
     * @return List<RoleResource>
     * @author CK
     * @date 2020/12/16 20:24
     */
    List<RoleResource> getRoleIdByResourceUrl(@Param(value = "resourceUrl") String resourceUrl);

}
