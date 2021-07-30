package com.itbear.impression;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.repositories.BlogRepository;
import com.itbear.impression.repositories.CategoryRepository;
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

    @Test
    public void test() throws Exception {
        List<Blog> list = blogService.getBlogByCategoryId(2L);
        for (Blog blog : list) {
            System.out.println(blog);
        }
    }

    public static void main(String[] args) {
    }
}
