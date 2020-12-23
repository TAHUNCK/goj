package org.goj.user.controller;


import org.goj.user.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CK
 * @since 2020-12-16
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping(value = "/initResourceRolesMap")
    Boolean initResourceRolesMap(){
        return resourceService.initResourceRolesMap();
    }

}

