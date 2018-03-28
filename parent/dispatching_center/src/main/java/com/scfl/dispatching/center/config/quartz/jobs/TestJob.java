package com.scfl.dispatching.center.config.quartz.jobs;

import com.scfl.dispatching.center.config.quartz.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 工作实现类(测试类)
 * @author ylw
 * @date 18-3-22 上午11:28
 * @param
 * @return
 */
public class TestJob implements BaseJob {
    private static Logger looger = LoggerFactory.getLogger(TestJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("测试开始---------------------");
        looger.debug("hello,Job执行时间:"+new Date());
    }
}
