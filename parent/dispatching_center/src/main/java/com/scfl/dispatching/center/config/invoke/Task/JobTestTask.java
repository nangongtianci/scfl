package com.scfl.dispatching.center.config.invoke.Task;

import com.scfl.base.enumerate.JobReportEnum;
import com.scfl.base.job.BaseJobTask;
import com.scfl.base.utils.ApplicationConst;
import com.scfl.dispatching.center.config.invoke.OuterJobClassLoader;
import com.scfl.dispatching.center.entity.JobRecord;
import com.scfl.dispatching.center.service.JobRecordService;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;

/**
 * 测试任务接口
 * @author ylw
 * @date 18-3-23 下午4:11
 * @param
 * @return
 */
public class JobTestTask extends BaseJobTask implements Runnable {

    private JobRecordService jobRecordService;
    private String jarName;
    private String className;
    private String methodName;

    public JobTestTask(JobRecordService jobRecordService,
                       String jarName,String className,String methodName){
        this.jobRecordService = jobRecordService;
        this.jarName = jarName;
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        JobRecord jobRecord = new JobRecord();
        try {
            OuterJobClassLoader classLoader = new OuterJobClassLoader(new URL[]{});
            classLoader.addJar(new File(ApplicationConst.OUTER_JAR_PATH+jarName).toURI().toURL());
            Class<?> clazz = classLoader.loadClass(className);

            // 运行状态
            jobRecord.setFullClassName((clazz.getPackage() == null?"none":clazz.getPackage())+"."+clazz.getName());
            jobRecord.setExecuteStatus(JobReportEnum.running.getValue());
            jobRecord.setExceptionDesc(JobReportEnum.running.getDescription());
            jobRecord.setMethodName(methodName);
            jobRecord.setCreateTime(new Date());
            jobRecord.setUpdateTime(new Date());
            jobRecordService.insert(jobRecord);

            Object object = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(methodName,int.class);
            method.invoke(object,120);
            classLoader.close();

            jobRecord.setExecuteStatus(JobReportEnum.end.getValue());
            jobRecord.setExceptionDesc(JobReportEnum.end.getDescription());
            jobRecord.setCreateTime(new Date());
            jobRecord.setUpdateTime(new Date());
            jobRecordService.updateById(jobRecord);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            jobRecord.setFullClassName(StringUtils.isBlank(jobRecord.getFullClassName())?"undefined":jobRecord.getFullClassName());
            jobRecord.setExecuteStatus(JobReportEnum.error.getValue());
            jobRecord.setMethodName(StringUtils.isBlank(jobRecord.getMethodName())?"undefined":jobRecord.getMethodName());
            jobRecord.setExceptionDesc(e.getMessage());
            jobRecord.setCreateTime(new Date());
            jobRecord.setUpdateTime(new Date());
            if(jobRecord.getId() <= 0){
                jobRecordService.insert(jobRecord);
            }else{
                jobRecordService.updateById(jobRecord);
            }
            return;
        }
    }
}
