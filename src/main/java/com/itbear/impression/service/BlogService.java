package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 18:24:29 星期六
 * <p>
 * features：
 */
public interface BlogService {

    List<Blog> queryAll();

    Page<Blog> getBlogByPage(Pageable pageable);

    List<Blog> getBlogByCategoryId(Long id) throws Exception;
}
