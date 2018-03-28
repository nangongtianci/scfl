package com.scfl.dispatching.center.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * 方法配置
 * </p>
 *
 * @author ylw
 * @since 2018-03-26
 */
@TableName("t_outer_invoking_method")
public class OuterInvokingMethod extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * class主键
     */
    private Integer pid;
    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "OuterInvokingMethod{" +
        ", pid=" + pid +
        ", methodName=" + methodName +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
