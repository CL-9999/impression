package com.itbear.impression.entities.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 16:45:36 星期日
 * <p>
 * features：
 */
@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer likes;

    private Integer views; // 文章浏览量

    private Integer comments;

    private String cover; // 文章封面

    @Lob
    private String content;

    private Long userId; // 用户id

    private Long categoryId;

    private Long tagId;

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间

}
