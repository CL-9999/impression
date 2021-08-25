package com.itbear.impression.exception;

import com.itbear.impression.entities.ResultCode;
import com.itbear.impression.entities.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.bear.blog")
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validException(MethodArgumentNotValidException e) {
        log.error("数据校验错误：{}, 异常类型：{}",e.getMessage(),e.getClass());

        BindingResult binding = e.getBindingResult();

        Map<String, String> map = new HashMap<>();
        binding.getFieldErrors().forEach((item) -> {
            map.put(item.getField(),item.getDefaultMessage());
        });

        return Result.error(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage()).data("data", map);
    }
}
