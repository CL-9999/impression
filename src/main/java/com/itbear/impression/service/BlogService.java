package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.vo.BlogVo;
import com.itbear.impression.entities.vo.QueryVo;
import com.itbear.impression.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 18:24:29 星期六
 * <p>
 * features：
 */
public interface BlogService {

    @Autowired
     BlogRepository BLOG_REPOSITORY = null;

    List<Blog> queryAll();

    Page<Blog> getBlogByPage(int current, int limit, QueryVo queryVo);

    Page<Blog> getBlogByPage(Pageable pageable);


    default List<Blog> getBlogByCategoryId(Long id) throws Exception {
        assert false;
        return BLOG_REPOSITORY.findAll();
    }

    /**
     *  index 首页获取博客详情，根据blogId
     * @param blogId 博客id
     * @return {@link Blog}
     */
    Blog getBlogDetailsByBlogId(Long blogId);

    List<Blog> getBlogBySort();

    void saveBlog(BlogVo blogVo); // 新增博客文章

    void deleteBlogById(Long id);
}
