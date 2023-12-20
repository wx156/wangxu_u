package com.kfm.goods.ex;

import com.kfm.goods.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 处理异常
@RestControllerAdvice
public class MyExceltionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        if (StringUtils.hasText(e.getMessage())){
            return Result.error(e.getMessage());
        }
        return Result.error("服务器发生错误，请重试");
    }
}