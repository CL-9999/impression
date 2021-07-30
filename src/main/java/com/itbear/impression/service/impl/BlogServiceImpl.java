package com.itbear.impression.service.impl;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.repositories.BlogRepository;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 18:24:57 星期六
 * <p>
 * features：
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Blog> queryAll() {

        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> getBlogByPage(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> getBlogByCategoryId(Long id) throws Exception {

        if (id == null) {
            throw new Exception("The category ID cannot be empty");
        }
        return blogRepository.getBlogByCategory_Id(id);
    }
}
