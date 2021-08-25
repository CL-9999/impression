package com.itbear.impression.entities.vo;

import com.itbear.impression.entities.pojo.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-13 10:27:44 星期五
 * <p>
 * features：
 */
@Data
public class BlogListVo {

    private Long id;
    private String title;
    private Category category;
    private List<TagVo> tagVo;
    private Date createTime;
    private Date modifyTime;
}
