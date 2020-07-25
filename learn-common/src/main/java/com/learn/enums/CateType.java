package com.learn.enums;

public enum CateType {
    CATE_TYPE_LEVEL_ONE(1,"一级分类"),

    CATE_TYPE_LEVEL_TWO(2,"二级分类"),

    CATE_TYPE_LEVEL_THREE(3,"三级分类");

    public final Integer type;

    public final String value;

    CateType(Integer type, String value) {
        this.type = type;
        this.value = value;
    };
}
