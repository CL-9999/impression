package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:49:28 星期日
 * <p>
 * features：
 */
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String avatar;

    private String email;

    @Lob
    private String content;


    /**
     * 评论类型【0：读者评论】【1：作者回复】
     */
    private int type;

    @ManyToOne
    private Blog blog;

    @ManyToOne
    private Comment parentComment;

    /**
     * 回复的留言
     */
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.EAGER)
    private List<Comment> replyComments = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; // 创建时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime; // 更新时间
}
