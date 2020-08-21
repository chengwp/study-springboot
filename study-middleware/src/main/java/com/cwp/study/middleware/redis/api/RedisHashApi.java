package com.cwp.study.middleware.redis.api;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.HashMap;

@Component
public  class RedisHashApi  {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 设置hash值
     *
     * @param key
     * @param value
     */
    public void putHashMap(String key, HashMap<String,Object> value){
        redisTemplate.opsForHash().putAll(key,value);
    }


    /**
     * 获取hash值
     *
     * @param key
     * @return
     */
    public  HashMap<String,Object>  getHashMapByKey(String key){
        return (HashMap<String, Object>) redisTemplate.opsForHash().entries(key);
    }




}
