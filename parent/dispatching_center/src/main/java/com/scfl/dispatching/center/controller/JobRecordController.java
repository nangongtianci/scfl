package com.scfl.dispatching.center.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.scfl.base.controller.BaseController;
import com.scfl.base.utils.Result;
import com.scfl.dispatching.center.entity.JobRecord;
import com.scfl.dispatching.center.service.JobRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 作业执行记录 前端控制器
 * </p>
 *
 * @author ylw
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/job/record")
public class JobRecordController extends BaseController{

    @Autowired
    private JobRecordService jobRecordService;

    @GetMapping("/page")
    public Result recordPage(Page<JobRecord> page){
        return Result.OK(jobRecordService.selectPage(page));
    }
}

