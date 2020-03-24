package com.imooc.sell.controller;

import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellExcetion;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/authorize")
    public String authorize(@RequestParam(value = "returnUrl") String returnUrl) {
        String url = "http://sell.xiaoma0121.cn/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info(url);
        log.info(redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping("userInfo")
    public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellExcetion(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        log.info(code);
        log.info(returnUrl);
        String openid = wxMpOAuth2AccessToken.getOpenId();
        log.info(openid);
        return "redirect:" + returnUrl + "?openid=" + openid;
    }
}

