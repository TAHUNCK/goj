package org.goj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.constant.RedisConstant;
import org.goj.common.entity.user.Resource;
import org.goj.common.entity.user.RoleResource;
import org.goj.common.entity.user.UserRole;
import org.goj.user.mapper.ResourceMapper;
import org.goj.user.service.ResourceService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @javax.annotation.Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    @Override
    public Boolean initResourceRolesMap() {
        try{
            QueryWrapper<Resource> resourceQueryWrapper=new QueryWrapper<>();
            resourceQueryWrapper.select("resource_url");
            Set<Resource> resources= new HashSet<>(super.list(resourceQueryWrapper));
            Map<String, List<String>> resourceRolesMap=resources.stream()
                    .collect(Collectors.toMap(Resource::getResourceUrl, t->{
                        List<RoleResource> list=resourceMapper.getRoleIdByResourceUrl(t.getResourceUrl());
                        return list.stream().map(a->a.getRoleId().toString()).collect(Collectors.toList());
                    }));
            redisTemplate.delete(RedisConstant.RESOURCE_ROLES_MAP);
            redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
