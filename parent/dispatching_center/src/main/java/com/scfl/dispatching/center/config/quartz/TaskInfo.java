package com.scfl.dispatching.center.config.quartz;

public class TaskInfo {
    // JOB名
    private String jobClassName=JobConstants.JobName.JOB_DEFAULT_NAME;
    // JOB组
    private String jobGroupName=JobConstants.JobGruop.JOB_DEFAULT_GROUP_NAME;
    // cron表达式
    private String cronExpression;

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
