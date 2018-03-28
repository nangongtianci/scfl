package com.scfl.dispatching.center.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.scfl.base.entity.BaseEntity;

/**
 * <p>
 * 类配置
 * </p>
 *
 * @author ylw
 * @since 2018-03-26
 */
@TableName("t_outer_invoking_class")
public class OuterInvokingClass extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * jar主键
     */
    private Integer pid;
    /**
     * 包路径(元字符)
     */
    @TableField("package_path")
    private String packagePath;
    /**
     * 包唯一标识
     */
    @TableField("package_flag")
    private String packageFlag;
    @TableField("class_name")
    private String className;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPackageFlag() {
        return packageFlag;
    }

    public void setPackageFlag(String packageFlag) {
        this.packageFlag = packageFlag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "OuterInvokingClass{" +
        ", pid=" + pid +
        ", packagePath=" + packagePath +
        ", packageFlag=" + packageFlag +
        ", className=" + className +
        ", createTime=" + super.getCreateTime() +
        ", updateTime=" + super.getUpdateTime() +
        "}";
    }
}
