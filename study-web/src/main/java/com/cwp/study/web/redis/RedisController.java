package com.cwp.study.web.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/user/add/{userName}")
    public void  registerUser(@PathVariable("userName") String userName){
        redisTemplate.opsForHash().getOperations().opsForHash().put(userName,"userName",userName);
    }



    @RequestMapping("/user/{userName}")
    public HashMap getUser(@PathVariable("userName") String userName){
        String userNameVaule= (String) redisTemplate.opsForHash().getOperations().opsForHash().get(userName,"userName");
         HashMap map=new  HashMap();
         map.put("userName",userNameVaule);
         return map;
    }





}
