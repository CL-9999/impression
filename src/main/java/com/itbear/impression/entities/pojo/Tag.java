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
 * @created 2021-07-18 17:08:57 星期日
 * <p>
 * features：
 */
@Data
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 标签名

    private int blogNo; // 1 表示博客的标签

    private int proNo; // 2 来表示项目的标签。

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间
}
