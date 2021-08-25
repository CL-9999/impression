package com.itbear.impression.entities;

import lombok.Getter;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-31 3:38:25 星期六
 * <p>
 * features：
 */
@Getter
public enum ResultCode {

    OK(200, "成功"), ERROR(222, "error");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
