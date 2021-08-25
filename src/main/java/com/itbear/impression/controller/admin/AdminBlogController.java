package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.entities.vo.*;
import com.itbear.impression.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-08 23:51:58 星期日
 * <p>
 * features：
 */
@RequestMapping(path = "/admin/blog")
@RestController
public class AdminBlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping(value = "/save")
    public Result save(@RequestBody BlogVo blog) {

        blogService.saveBlog(blog);
        return Result.ok();
    }

    @PostMapping(value = "/blogs/{current}/{limit}")
    public Result page(@PathVariable(value = "current") int current,
                       @PathVariable(value = "limit") int limit,
                       @RequestBody QueryVo queryVo) {
      Page<Blog> page = blogService.getBlogByPage(current -1, limit, queryVo);

        List<BlogListVo> blogListVoCollected = page.getContent().stream().map(blog -> {
            BlogListVo blogListVo = new BlogListVo();
            blogListVo.setId(blog.getId());
            blogListVo.setTitle(blog.getTitle());
            blogListVo.setCreateTime(blog.getCreateTime());
            blogListVo.setModifyTime(blog.getModifyTime());

            blogListVo.setCategory(blog.getCategory());
            List<TagVo> tagsCollected = blog.getTags().stream().map(tag -> {
                TagVo tagVo = new TagVo();
                tagVo.setId(tag.getId());
                tagVo.setName(tag.getName());
                return tagVo;
            }).collect(Collectors.toList());
            blogListVo.setTagVo(tagsCollected);
            return blogListVo;
        }).collect(Collectors.toList());

        return Result.ok().data("total", page.getTotalElements()).data("content", blogListVoCollected);
    }

    @DeleteMapping(path = "/del/{blogId}")
    public Result deleteBlogById(@PathVariable(value = "blogId") Long id) {

        blogService.deleteBlogById(id);
        return Result.ok();
    }

    @GetMapping(path = "/info/{id}")
    public Result getBlogInfoById(@PathVariable(value = "id") Long id) {

        Blog blogInfo = blogService.getBlogDetailsByBlogId(id);
        return Result.ok().data("blogInfo", blogInfo);
    }
}
