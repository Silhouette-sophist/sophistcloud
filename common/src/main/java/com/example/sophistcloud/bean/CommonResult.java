package com.example.sophistcloud.bean;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult<T> {
    Integer code;
    String message;
    T data;

    public static<T> CommonResult<T> success(T data) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMessage("success");
        commonResult.setData(data);
        return commonResult;
    }

    public static <Throwable> CommonResult<Throwable> error(Throwable throwable) {
        CommonResult<Throwable> commonResult = new CommonResult<>();
        commonResult.setCode(400);
        commonResult.setMessage("failed");
        commonResult.setData(throwable);
        return commonResult;
    }
}
