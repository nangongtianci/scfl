package com.scfl.base.enumerate;
/**
 * 作业运行报告状态
 * @author ylw
 * @date 18-3-27 上午10:00
 * @param
 * @return
 */
public enum JobReportEnum {
    running("running","运行状态"),
    end("end","正常结束"),
    error("error","错误退出");

    private final String value;
    private final String description;

    JobReportEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    /**
     * 获取值
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取描述信息
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public static JobReportEnum getStatusState(Integer value) {
        if (null == value)
            return null;
        for (JobReportEnum _enum : JobReportEnum.values()) {
            if (value.equals(_enum.getValue()))
                return _enum;
        }
        return null;
    }

    public static JobReportEnum getStatusState(String description) {
        if (null == description)
            return null;
        for (JobReportEnum _enum : JobReportEnum.values()) {
            if (description.equals(_enum.getDescription()))
                return _enum;
        }
        return null;
    }
}
