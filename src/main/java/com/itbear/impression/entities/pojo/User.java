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
 * @created 2021-07-10 16:08:17 星期六
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs; // 博客id

    @OneToMany(mappedBy = "user")
    private List<Project> projects; // 项目id关联

    @OneToMany(mappedBy = "user")
    private List<Skill> skill; // 技能id关联

    @OneToMany(mappedBy = "user")
    private List<Comment> comments; // 评论id关联

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime; // 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime modifyTime; // 更新时间
}
