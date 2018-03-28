package com.scfl.dispatching.center.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * 作业执行记录
 * </p>
 *
 * @author ylw
 * @since 2018-03-23
 */
@TableName("t_job_record")
public class JobRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 包点类名称
     */
    @TableField("full_class_name")
    private String fullClassName;
    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;
    /**
     * 运行中,正常结束,错误退出
     */
    @TableField("execute_status")
    private String executeStatus;
    /**
     * 异常描述
     */
    @TableField("exception_desc")
    private String exceptionDesc;

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }

    @Override
    public String toString() {
        return "JobRecord{" +
        ", fullClassName=" + fullClassName +
        ", methodName=" + methodName +
        ", executeStatus=" + executeStatus +
        ", exceptionDesc=" + exceptionDesc +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
