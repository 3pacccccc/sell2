package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(1, "上架"),
    DOWN(0, "下架");

    private Integer code;

    private String desc;

    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
