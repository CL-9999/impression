package com.itbear.impression;

import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-29 14:01:46 星期四
 * <p>
 * features：
 */
@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void getCategory() {
//        Category categoryName = categoryRepository.getCategoryName();
//        System.out.println(categoryName);
    }
}

