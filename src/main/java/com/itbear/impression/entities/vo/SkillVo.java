package com.itbear.impression.entities.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-31 3:45:46 星期六
 * <p>
 * features：
 */
@Data
public class SkillVo {

    private Long id;
    private String name;
    private String description;
    private String username;
    private Date createTime;
    private String cover;
    private List<String> tags;

}
