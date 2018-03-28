package com.scfl.dispatching.center.config.quartz.jobs;

import com.scfl.dispatching.center.config.quartz.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class TestJob2 implements BaseJob {
    Logger logger = LoggerFactory.getLogger(TestJob2.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("test2 任务执行时间:"+new Date());
    }
}
