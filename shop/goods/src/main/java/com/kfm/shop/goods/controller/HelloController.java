package com.kfm.shop.goods.controller;


import com.kfm.shop.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "hello",description = "测试")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "hello接口", notes = "hello接口1111")
    @ApiResponses(
            @ApiResponse(code = 200, message = "成功", response = Result.class)
    )
    public Result hello() {
        return Result.ok();
    }
}
