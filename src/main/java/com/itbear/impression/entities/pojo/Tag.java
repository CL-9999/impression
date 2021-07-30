package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs;

    @ManyToMany(mappedBy = "tag")
    private List<Project> project;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime; // 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime modifyTime; // 更新时间
}
