package com.itbear.impression.entities.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-10 16:08:17 星期六
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String email;
    private String avatar;
    private String video;
    private String website;

    private String address;

    private String phone;

    private String introduction;

    private Long blogId;

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间
}
