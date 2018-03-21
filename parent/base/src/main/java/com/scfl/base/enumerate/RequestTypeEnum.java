package com.scfl.base.enumerate;

/**
 * 请求类型枚举
 * @author ylw
 * @date 18-3-14 下午5:16
 * @param
 * @return
 */
public enum  RequestTypeEnum {
    GET(1,"get请求"),
    POST(2,"post请求"),
    PUT(3,"put请求"),
    DEL(4,"del操作");

    private int value;
    private String desc;

    private RequestTypeEnum(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
