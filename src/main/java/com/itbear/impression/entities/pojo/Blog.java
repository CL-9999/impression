package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    private Integer comments; // 评论数

    private String cover; // 文章封面

    @Lob
    private String content;

    // blog是多的一方，user是一的一方
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user; // 用户id

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category; // 分类


    @ManyToMany
    @JoinTable(name = "blogs_tags",joinColumns = @JoinColumn(name = "blog_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "tag_id",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)),foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Tag> tags; // 标签

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime; // 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modifyTime; // 更新时间

}
