package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 16:45:36 星期日
 * <p>
 * features：
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@NoArgsConstructor
@Entity
@Data
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

//    @ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category; // 分类


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "blogs_tags",joinColumns = @JoinColumn(name = "blog_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "tag_id",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)),foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<Tag> tags; // 标签

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime; // 创建时间

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifyTime; // 更新时间


}
