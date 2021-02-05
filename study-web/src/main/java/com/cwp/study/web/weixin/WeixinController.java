package com.cwp.study.web.weixin;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeixinController {


    @Autowired
    private WxMpService mpService;

    @GetMapping("/weixin")
    public String weixin() throws WxErrorException {
        // this.mpService.getWxMpConfigStorage().getAppId();
        return  this.mpService.getAccessToken();
    }
}
