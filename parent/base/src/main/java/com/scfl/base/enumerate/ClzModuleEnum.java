package com.scfl.base.enumerate;

public enum ClzModuleEnum {
    clz("clz","类"),
    method("method","方法");
    /**
     * 值 String型
     */
    private final String value;
    /**
     * 模块名称 String型
     */
    private final String name;

    ClzModuleEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 获取值
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取描述信息
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public static ModuleEnum getByValue(String value) {
        if (null == value)
            return null;
        for (ModuleEnum _enum : ModuleEnum.values()) {
            if (value.equals(_enum.getValue()))
                return _enum;
        }
        return null;
    }

    public static ModuleEnum getByName(String name) {
        if (null == name)
            return null;
        for (ModuleEnum _enum : ModuleEnum.values()) {
            if (name.equals(_enum.getName()))
                return _enum;
        }
        return null;
    }
}
