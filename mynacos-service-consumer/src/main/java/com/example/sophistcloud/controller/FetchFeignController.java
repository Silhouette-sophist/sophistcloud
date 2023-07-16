package com.example.sophistcloud.controller;


import com.example.sophistcloud.bean.CommonResult;
import com.example.sophistcloud.service.ServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/consumer")
public class FetchFeignController {

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    ServiceProviderClient serviceProviderClient;

    @GetMapping("/fetch")
    public CommonResult<String> fetch(){
        CommonResult<String> provider = serviceProviderClient.provider();
        provider.setData(String.format("%s, called after provider: %s:%d", provider.getData(), applicationName, serverPort));
        return provider;
    }
}
