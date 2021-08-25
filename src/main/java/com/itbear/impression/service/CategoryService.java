package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.vo.CategoryVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-29 13:47:59 星期四
 * <p>
 * features：
 */
public interface CategoryService {

    List<CategoryVo> getAll();

    List<Category> getBlogByCategoryId(Pageable pageable);
}
