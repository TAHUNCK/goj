package org.goj.practice.controller;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.goj.common.entity.user.Classify;
import org.goj.common.model.Result;
import org.goj.practice.service.ClassifyService;
import org.goj.practice.vo.ClassifyCascaderVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目分类 前端控制器
 * </p>
 *
 * @author CK
 * @since 2020-12-07
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;

    @GetMapping("/listCascader")
    public Result<List<ClassifyCascaderVO>> getAllClassify(){
        List<ClassifyCascaderVO> classify=classifyService.listClassifyCascader();
        Assert.notNull(classify,"查询分类失败！");
        return Result.succeed("查询分类成功！",classify);
    }

}

