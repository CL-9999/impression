package com.itbear.impression.entities.vo;

import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-21 8:39:40 星期六
 * <p>
 * features：
 */
@Data
public class ProjectVo {

    private Long id;
    private String name;
//    private String description;
    private String username;
    private Date createTime;
    private String cover;
    private Category category;
    private List<String> tags;
}
