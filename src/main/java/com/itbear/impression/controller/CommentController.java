package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Comment;
import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.service.BlogService;
import com.itbear.impression.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-16 16:30:13 星期一
 * <p>
 * features：
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/comments/{blogId}")
    public String comments(@PathVariable(value = "blogId") Long blogId, Model model) {
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog-details-full :: commentList";
    }

    @PostMapping( "/comments")
    public String postComments(Comment comment) {

        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlogDetailsByBlogId(blogId));
        commentService.postComments(comment);

        return "redirect:/comments/" + blogId;
    }
}
