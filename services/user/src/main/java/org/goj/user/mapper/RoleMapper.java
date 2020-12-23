package org.goj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.goj.common.entity.user.Role;

import java.util.List;

/**
 * <p>
 * 权限授予 Mapper 接口
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 根据用户ID查询其拥有的角色
     *
     * @param userId 用户ID
     * @return List<Role>
     * @author CK
     * @date 2020/12/16 19:37
     */
    List<Role> getRoleByUser(@Param(value = "userId") Long userId);
}
