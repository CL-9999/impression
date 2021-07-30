package com.itbear.impression.entities.vo;

import lombok.Data;

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
public class Result extends HashMap<String, Object> {

    private int code;
    private String message;

    private Map<String, Object> data = new HashMap<>();

    public Result ok() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("ok");
        return result;
    }

    public Result error() {
        var result = new Result();
        result.setCode(222);
        result.setMessage("error");
        return result;
    }

//    public Result put(String key, String value) {
//        Result result = new Result();
//        data.put(key, value);
//    }
}
