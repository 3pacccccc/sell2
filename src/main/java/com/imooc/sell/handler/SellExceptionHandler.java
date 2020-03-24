package com.imooc.sell.handler;


import com.imooc.sell.exception.SellExcetion;
import com.imooc.sell.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellExcetion.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 修改返回的状态码
    public ResultVo handlerSellExceptionHandler(SellExcetion e){
        return ResultVo.error(e.getCode(), e.getMessage());
    }
}
