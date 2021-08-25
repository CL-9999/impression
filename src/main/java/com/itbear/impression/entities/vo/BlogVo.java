package com.itbear.impression.entities.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.Tag;
import com.itbear.impression.entities.pojo.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-09 2:11:57 星期一
 * <p>
 * features：
 */
@Data
public class BlogVo {

    private Long id;

    private String title;

    private String cover; // 文章封面

    private String content;

    private CategoryVo category; // 分类

    private List<TagVo> tags; // 标签

}
