package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.*;
import com.itbear.impression.repositories.BlogRepository;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.service.BlogService;
import com.itbear.impression.service.ProjectService;
import com.itbear.impression.service.SkillService;
import com.itbear.impression.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-19 19:37:23 星期一
 * <p>
 * features：
 */
@Controller(value = "indexController")
public class IndexController {

    private final static String INDEX = "index";

    @Autowired
    private SkillService skillService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(path = "/index")
    public String toIndex(Model model) {

        List<Skill> skills = skillService.queryAll();
        model.addAttribute("skills", skills);
        List<Project> projects = projectService.queryAll();
        List<Project> collect = projects.stream().limit(6).collect(Collectors.toList());
        model.addAttribute("projects", collect);

//        List<Tag> tags = tagService.getAll();
//        model.addAttribute("tags", tags);

        List<Blog> blogs = blogService.queryAll()
                .stream().limit(3).collect(Collectors.toList());
        model.addAttribute("blogs", blogs);

        return INDEX;
    }
}

