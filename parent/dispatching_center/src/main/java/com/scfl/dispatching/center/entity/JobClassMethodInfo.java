package com.scfl.dispatching.center.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * job方法配置表
 * </p>
 *
 * @author ylw
 * @since 2018-03-20
 */
@TableName("t_job_class_method_info")
public class JobClassMethodInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 完整的类路径
     */
    @TableField("method_name")
    private String methodName;
    private Integer pid;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "JobClassMethodInfo{" +
        ", methodName=" + methodName +
        ", pid=" + pid +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
