package com.scfl.dispatching.center.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * jar配置
 * </p>
 *
 * @author ylw
 * @since 2018-03-26
 */
@TableName("t_outer_invoking_jar")
public class OuterInvokingJar extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * jar包名称
     */
    @TableField("jar_name")
    private String jarName;
    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    @Override
    public String toString() {
        return "OuterInvokingJar{" +
        ", jarName=" + jarName +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
