package com.itbear.impression.service.impl;

import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.vo.CategoryVo;
import com.itbear.impression.exception.CustomException;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-29 13:48:11 星期四
 * <p>
 * features：
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryVo> getAll() {

        return categoryRepository.findAll().stream().map(category -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category, categoryVo);
            return categoryVo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Category> getBlogByCategoryId(Pageable pageable) {

        return categoryRepository.getBlogByCategoryId(pageable);
    }
}
