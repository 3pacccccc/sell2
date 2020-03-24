package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    NEW(0, "新下单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),

    ;
    private Integer code;

    private String msg;

}
