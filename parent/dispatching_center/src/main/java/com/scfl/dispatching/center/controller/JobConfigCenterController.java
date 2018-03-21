package com.scfl.dispatching.center.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.scfl.base.controller.BaseController;
import com.scfl.base.enumerate.RequestTypeEnum;
import com.scfl.base.utils.Result;
import com.scfl.dispatching.center.entity.JobClassInfo;
import com.scfl.dispatching.center.entity.JobClassMethodInfo;
import com.scfl.dispatching.center.service.JobClassInfoService;
import com.scfl.dispatching.center.service.JobClassMethodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * JOB控制映射接口
 * @author ylw
 * @date 18-3-14 下午5:10
 * @param
 * @return
 */
@RestController
@RequestMapping("/cfg/job")
public class JobConfigCenterController extends BaseController{

    @Autowired
    private JobClassInfoService jobClassInfoService;
    @Autowired
    private JobClassMethodInfoService jobClassMethodInfoService;

    @GetMapping("/clz")
    public Result clzList(){
        return Result.OK(jobClassInfoService.selectList(null));
    }

    @GetMapping("/clz/relation/method/{pid}")
    public Result clzRelationMethodList(@PathVariable String pid){
        return Result.OK(jobClassMethodInfoService.selectList(new EntityWrapper<JobClassMethodInfo>().where("pid={0}",pid)));
    }

    @GetMapping("/clz/method")
    public Result clzMethodList(){
        return Result.OK(jobClassMethodInfoService.selectList(null));
    }

    @PostMapping("/clz")
    public Result addClzMapping(JobClassInfo jobClassInfo){
        if(jobClassInfoService.insert(jobClassInfo)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }

    @PostMapping("/clz/method")
    public Result addCLzMethodMapping(JobClassMethodInfo jobClassMethodInfo){
        if(jobClassMethodInfoService.insert(jobClassMethodInfo)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }

    @PutMapping("/clz")
    public Result updateClzMapping(JobClassInfo jobClassInfo){
        if(jobClassInfoService.updateById(jobClassInfo)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }

    @PutMapping("/clz/method")
    public Result updateCLzMethodMapping(JobClassMethodInfo jobClassMethodInfo){
        if(jobClassMethodInfoService.updateById(jobClassMethodInfo)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }

    @GetMapping("/clz/{id}")
    public Result delClzMapping(@PathVariable Integer id){
        if(jobClassInfoService.deleteById(id)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }

    @GetMapping("/clz/method/{id}")
    public Result delClzMethodMapping(@PathVariable Integer id){
        if(jobClassMethodInfoService.deleteById(id)){
            return Result.OK();
        }else{
            return Result.FAIL();
        }
    }
}
