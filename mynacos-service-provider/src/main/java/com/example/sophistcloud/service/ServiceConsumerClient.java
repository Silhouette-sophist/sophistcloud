package com.example.sophistcloud.service;

import com.example.sophistcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mynacos-service-consumer")
public interface ServiceConsumerClient {

    @GetMapping("/consumer/fetch")
    CommonResult<String> fetch();
}
