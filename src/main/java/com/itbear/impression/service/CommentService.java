package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Comment;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-16 16:31:59 星期一
 * <p>
 * features：
 */
public interface CommentService {

    Comment postComments(Comment comment);

    List<Comment> listCommentByBlogId(Long blogId);
}
