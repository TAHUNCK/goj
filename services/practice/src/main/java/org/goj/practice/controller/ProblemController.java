package org.goj.practice.controller;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.goj.common.entity.practice.Problem;
import org.goj.common.model.Result;
import org.goj.practice.service.ProblemService;
import org.goj.practice.vo.ProblemVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目 前端控制器
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Resource
    private ProblemService problemService;

    @PutMapping
    public Result<Boolean> insertProblem(@RequestBody Problem problem) {
        boolean flag = problemService.save(problem);
        Assert.isTrue(flag, "添加题目失败！");
        return Result.succeed("添加题目成功！", flag);
    }

    @GetMapping("/listProblem")
    public Result<Page<ProblemVO>> getProblemList(@RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
                                                  @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                                  @RequestParam(value = "classifyIdList", required = false) List<Long> classifyIdList,
                                                  @RequestParam(value = "sort", required = false, defaultValue = "1") Integer sort) {
        Page<ProblemVO> problemPageVO = problemService.getProblemConditionPage(current, size, classifyIdList, sort);
        return Result.succeed("查询题目成功！", problemPageVO);
    }

}

