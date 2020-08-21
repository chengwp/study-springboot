package com.cwp.study.web.redis.controller;

import com.cwp.study.middleware.redis.api.RedisHashApi;
import com.cwp.study.web.redis.model.req.UserAddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisHashApi redisHashApi;


    @RequestMapping("/user/add")
    public void  registerUser(@RequestBody UserAddReq  userAddReq){


    }



    @RequestMapping("/user/{userName}")
    public HashMap getUser(@PathVariable("userName") String userName){
        return new HashMap();
    }





}
