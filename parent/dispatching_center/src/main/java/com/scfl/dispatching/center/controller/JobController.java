package com.scfl.dispatching.center.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.scfl.base.controller.BaseController;
import com.scfl.base.exception.BizException;
import com.scfl.base.utils.Result;
import com.scfl.dispatching.center.config.quartz.BaseJob;
import com.scfl.dispatching.center.config.quartz.TaskInfo;
import com.scfl.dispatching.center.service.JobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config/job")
public class JobController extends BaseController {
    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(JobController.class);

    @Autowired
    @Qualifier("Scheduler")
    private Scheduler scheduler;
    @Autowired
    private JobService jobService;

    // 添加JOB
    @PostMapping
    public Result addJob(TaskInfo taskInfo) throws Exception
    {
        try {
            // 启动调度器
            scheduler.start();
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(taskInfo.getJobClassName()).getClass())
                    .withIdentity(taskInfo.getJobClassName(),taskInfo.getJobGroupName()).build();
            // 表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskInfo.getCronExpression());
            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(taskInfo.getJobClassName(),taskInfo.getJobGroupName())
                    .withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail,trigger);
            return Result.OK();
        } catch (SchedulerException e) {
            logger.error("创建定时任务失败"+e);
            throw new BizException("创建定时任务失败");
        }
    }

    // 暂停JOB
    @PostMapping(value="/pause")
    public Result pauseJob(TaskInfo taskInfo) throws Exception
    {
        scheduler.pauseJob(JobKey.jobKey(taskInfo.getJobClassName(),taskInfo.getJobGroupName()));
        return Result.OK();
    }

    // 重新开始
    @PostMapping(value="/resume")
    public Result resumeJob(String jobClassName,String jobGroupName) throws Exception
    {
        scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
        return Result.OK();
    }

    // 重新排程
    @PostMapping(value="/reschedule")
    public Result rescheduleJob(TaskInfo taskInfo) throws Exception
    {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(taskInfo.getJobClassName(),taskInfo.getJobGroupName());
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskInfo.getCronExpression());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey,trigger);
            return Result.OK();
        } catch (SchedulerException e) {
            logger.error("更新定时任务失败"+e);
            throw new BizException("更新定时任务失败");
        }
    }

    @PostMapping(value="/delete")
    public Result deleteJob(TaskInfo taskInfo) throws Exception
    {
        scheduler.pauseTrigger(TriggerKey.triggerKey(taskInfo.getJobClassName(),taskInfo.getJobGroupName()));
        scheduler.unscheduleJob(TriggerKey.triggerKey(taskInfo.getJobClassName(),taskInfo.getJobGroupName()));
        scheduler.deleteJob(JobKey.jobKey(taskInfo.getJobClassName(),taskInfo.getJobGroupName()));
        return Result.OK();
    }

    @GetMapping
    public Result queryJob(Page<Map> page)
    {
        return Result.OK(jobService.selectJobAndTriggerDetailsPage(page));
    }

    protected BaseJob getClass(String classname) throws Exception
    {
        Class<?> clz = Class.forName(classname);
        return (BaseJob)clz.newInstance();
    }
}
