package com.example.sophistcloud.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.sophistcloud.entity.SimpleUserInfo;
import com.example.sophistcloud.service.ISimpleUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/sql")
public class MybatisPlugController {

    @Autowired
    ISimpleUserInfoService simpleUserInfoService;

    @GetMapping("/user")
    public Object saveUser(){
        List<SimpleUserInfo> collectUsers = IntStream.range(0, 10)
                .mapToObj(item -> {
                    SimpleUserInfo simpleUserInfo = new SimpleUserInfo();
                    simpleUserInfo.setName(StrUtil.format("index:{}", item));
                    simpleUserInfo.setUuid(UUID.randomUUID().toString());
                    simpleUserInfo.setAddress(StrUtil.format("address index: {}", simpleUserInfo.getUuid().substring(5, 10)));
                    return simpleUserInfo;
                }).collect(Collectors.toList());
        return simpleUserInfoService.saveBatch(collectUsers);
    }

    @GetMapping("/search")
    public Object searchUser(){
        LambdaQueryWrapper<SimpleUserInfo> queryWrapper = new LambdaQueryWrapper<>();
        List<Integer> indexs = IntStream.generate(() -> RandomUtil.randomInt(1, 10)).limit(5).boxed().collect(Collectors.toList());
        log.info("search indexs: {}", indexs);
        queryWrapper.in(SimpleUserInfo::getId, indexs);
        return simpleUserInfoService.list(queryWrapper);
    }
}
