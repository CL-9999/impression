package com.itbear.impression.entities.vo;

import com.itbear.impression.entities.ResultCode;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-30 18:01:09 星期五
 * <p>
 * features：
 */
@Data
public class Result implements Serializable {

    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private Result() {
    }

    public static Result ok() {
        Result result = new Result();
        result.setCode(ResultCode.OK.getCode());
        result.setMessage(ResultCode.OK.getMessage());
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMessage());
        return result;
    }

    public static Result error(int code, String message) {
        Result result = new Result();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMessage());
        return result;
    }

    /**
     * 返回结果封装
     *
     * @param key   唯一标识
     * @param value 数据结果集
     * @return {@link Result}
     */
    public Result data(String key, Object value) {
        data.put(key, value);
        return this;
    }

    /**
     * 返回结果封装
     *
     * @param map Map对象
     * @return {@link Result}
     */
    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    //异常处理
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }
}
