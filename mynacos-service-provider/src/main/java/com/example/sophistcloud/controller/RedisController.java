package com.example.sophistcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/save")
    public Object save(@RequestParam("key") String key){
        String value = UUID.fastUUID().toString();
        stringRedisTemplate.opsForValue().set(key, value);
        return value;
    }

    @GetMapping("/search")
    public Object search(@RequestParam("key") String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
