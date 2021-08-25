package com.itbear.impression.entities.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:00:27 星期日
 * <p>
 * features：
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 技能名称

    @Lob
    private String content; // 技能介绍内容;

    private String cover; // 技能详情封面

    private String description;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    private String tagOne;
    private String tagTwo;
    private String tagThree;
    private String tagFour;
    private String tagFive;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime; // 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modifyTime; // 更新时间

}
