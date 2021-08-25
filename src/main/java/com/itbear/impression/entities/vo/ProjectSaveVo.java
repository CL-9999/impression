package com.itbear.impression.entities.vo;

import com.itbear.impression.entities.pojo.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-22 9:44:23 星期日
 * <p>
 * features：
 */
@Data
public class ProjectSaveVo {

    private Long id;
    private String name;
    private String type;
    private String gitee;
    private String content;
    private String github;
    private Date createTime;
    private String cover;
    private CategoryVo category;
    private List<TagVo> tag;
}
