package com.itbear.impression.entities.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:36:21 星期日
 * <p>
 * features：
 */
@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cover;

    @Lob
    private String content;

    private String type;

    private String github;

    private String gitee;

    private Long userId; // 用户id

    private Long categoryId;

    private Long tagId;

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间

}
