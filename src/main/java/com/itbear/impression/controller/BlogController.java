package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.CategoryVo;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller(value = "blogController")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/blog")
    public String blog(@PageableDefault(size = 3, sort = { "modifyTime" },
            direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {

        Page<Blog> page =  blogService.getBlogByPage(pageable);
        model.addAttribute("blogPages", page);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "blog";
    }


    @GetMapping(path = "/blog/detail")
    public String detail() {

        return "blog-details";
    }

//    @GetMapping(path = "/category/{categoryId}")
//    public String category(@PathVariable(value = "categoryId") Long categoryId, Model model) {
//
//        Category category = categoryRepository.getById(categoryId);
//        model.addAttribute("category", category);
//        model.addAttribute("categoryName", category.getName());
//        return "blog";
//    }
}
