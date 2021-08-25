package com.itbear.impression;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.Comment;
import com.itbear.impression.repositories.BlogRepository;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.repositories.CommentRepository;
import com.itbear.impression.service.BlogService;
import com.itbear.impression.service.impl.BlogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 19:05:42 星期六
 * <p>
 * features：
 */
@SpringBootTest
public class BlogTest {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void test() {
        Blog blog = new Blog();
        blog.setId(1L);
        Integer count = commentRepository.countCommentsByBlog(blog);
        System.out.println(count);
    }


}
