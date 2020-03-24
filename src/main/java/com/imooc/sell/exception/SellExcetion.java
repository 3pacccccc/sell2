package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;
import lombok.Getter;

@Getter
public class SellExcetion extends RuntimeException {

    private Integer code;

    public SellExcetion(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellExcetion(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
