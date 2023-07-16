package com.example.sophistcloud.controller;

import com.example.sophistcloud.bean.CommonResult;
import com.example.sophistcloud.service.ServiceConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    ServiceConsumerClient serviceConsumerClient;

    @PostMapping("/provider")
    public CommonResult<String> provider(){
        return CommonResult.success(String.format("%s:%d resp at: %s", applicationName, serverPort, new Date()));
    }

    @GetMapping("/consumer")
    public CommonResult<String> consumer(){
        return serviceConsumerClient.fetch();
    }
}
