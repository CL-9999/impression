package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-16 16:33:22 星期一
 * <p>
 * features：
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
    Integer countCommentsByBlog(Blog blog);

    void deleteCommentByBlog(Blog blog);
}
