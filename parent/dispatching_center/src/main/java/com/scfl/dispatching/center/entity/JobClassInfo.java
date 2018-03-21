package com.scfl.dispatching.center.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * job工作类信息
 * </p>
 *
 * @author ylw
 * @since 2018-03-20
 */
@TableName("t_job_class_info")
public class JobClassInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("full_class_path")
    private String fullClassPath;

    public String getFullClassPath() {
        return fullClassPath;
    }

    public void setFullClassPath(String fullClassPath) {
        this.fullClassPath = fullClassPath;
    }

    @Override
    public String toString() {
        return "JobClassInfo{" +
        ", fullClassPath=" + fullClassPath +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
