package org.goj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.goj.common.entity.user.User;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
public interface UserService extends IService<User> {

    /**
     * 添加一个新用户且分配一个角色
     *
     * @param email 用户邮箱
     * @param password 用户密码
     * @return boolean
     * @author CK
     * @date 2020/12/17 14:12
     */
    boolean insertUserAndUserRole(String email,String password);
}
