package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:08:57 星期日
 * <p>
 * features：
 */

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"blogs", "project"})
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 标签名

//    @ManyToMany(mappedBy = "tags")
//    private List<Blog> blogs;

//    @ManyToMany(mappedBy = "tag", fetch = FetchType.EAGER)
//    private Set<Project> project;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime; // 创建时间

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifyTime; // 更新时间

}
