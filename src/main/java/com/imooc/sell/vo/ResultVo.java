package com.imooc.sell.vo;


import com.imooc.sell.enums.ResultStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T data;

    private ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResultVo<T> success(T t) {
        return new ResultVo<T>(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMsg(), t);
    }

    public static ResultVo error(Integer code, String msg){
        return new ResultVo(code, msg);
    }
}
