package com.itbear.impression.entities.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:08:52 星期日
 * <p>
 * features：
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 分类名称


    private int blogNo; // 1 表示博客分类

    private int proNo; // 2 来表示项目的分类。

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间
}
