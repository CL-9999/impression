package com.itbear.impression.entities.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-18 17:00:27 星期日
 * <p>
 * features：
 */
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

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime modifyTime; // 更新时间

//    private String[] categories; // 技能分类
//    private String[] tags; // 技能标签
}
