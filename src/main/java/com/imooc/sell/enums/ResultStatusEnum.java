package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  ResultStatusEnum {
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    NOT_FOUND(404, "未查询到")
    ;
    private Integer code;

    private String msg;

}
