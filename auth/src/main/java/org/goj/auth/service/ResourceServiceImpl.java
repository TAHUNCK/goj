package org.goj.auth.service;

import org.goj.feign.feign.UserFeignClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author CK
 * @date 2020/11/22 16:46
 */
@Service
public class ResourceServiceImpl {

    @Resource
    UserFeignClient userFeignClient;

    @PostConstruct
    public void initData() {
        Boolean flag=userFeignClient.initResourceRolesMap();
        System.out.println("路径资源映射角色初始化结果："+flag);
    }

}
