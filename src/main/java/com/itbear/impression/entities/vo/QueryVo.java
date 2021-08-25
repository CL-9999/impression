package com.itbear.impression.entities.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-13 10:39:06 星期五
 * <p>
 * features：
 */
@Data
public class QueryVo {

    private String title;
    private Date createTime;
    private Date modifyTime;
}
