package com.example.sophistcloud.service;

import com.example.sophistcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mynacos-service-provider")
public interface ServiceProviderClient {

    @PostMapping("/feign/provider")
    CommonResult<String> provider();
}
