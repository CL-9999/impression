package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.service.BlogService;
import com.itbear.impression.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/blog")
    public String blog(@PageableDefault(size = 7, sort = { "createTime" },
            direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {

        Page<Blog> page =  blogService.getBlogByPage(pageable);
        model.addAttribute("blogPages", page);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Blog> sortedBlogs =  blogService.getBlogBySort();
        model.addAttribute("sortedBlogs", sortedBlogs);

        return "blog-list-full";
    }

//    @GetMapping(path = "/category/{categoryId}/blogs")
//    public String getBlogsByCategory(@PathVariable(value = "categoryId") Long categoryId, Pageable pageable, Model model) {
//
//        List<Category> list = categoryRepository.getBlogByCategoryId(pageable);
//        for (Category category : list) {
//            List<Blog> blogs = category.getBlog();
//            model.addAttribute("blogLists", blogs);
//        }
//        return "blog";
//    }

    @Autowired
    private CommentService commentService;

    @GetMapping(path = "/blog/{blogId}/details")
    public String blogDetails(@PathVariable(value = "blogId") Long blogId, Model model) {

        Blog blog = blogService.getBlogDetailsByBlogId(blogId);
        model.addAttribute("blogsList", blog);

        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));

        List<Blog> sortedBlogs =  blogService.getBlogBySort();
        model.addAttribute("sortedBlogs", sortedBlogs);

        return "blog-details-full";
    }


}
