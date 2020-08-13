package com.cwp.study.middleware.redis.api;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public  class RedisHashApi implements InitializingBean {

    @Autowired
    private RedisTemplate redisTemplate;


    private HashOperations hashOperations;




    public void addHash(String key, HashMap<String,Object> value){
        hashOperations.putAll(key,value);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
         hashOperations=redisTemplate.opsForHash();
    }
}
