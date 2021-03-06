package com.imooc.sell.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WexinController {

    @GetMapping("/auth")
    public void auth(@RequestParam(value = "code") String code) {
        log.info("进入auth方法");
        log.info(code);
    }
}
