package com.itbear.impression.service.impl;

import com.itbear.impression.config.MarkdownUtils;
import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.Tag;
import com.itbear.impression.entities.pojo.User;
import com.itbear.impression.entities.vo.BlogVo;
import com.itbear.impression.entities.vo.CategoryVo;
import com.itbear.impression.entities.vo.QueryVo;
import com.itbear.impression.entities.vo.TagVo;
import com.itbear.impression.exception.CustomException;
import com.itbear.impression.repositories.BlogRepository;
import com.itbear.impression.repositories.CategoryRepository;
import com.itbear.impression.repositories.CommentRepository;
import com.itbear.impression.service.BlogService;
import com.itbear.impression.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 18:24:57 星期六
 * <p>
 * features：
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> queryAll() {

        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> getBlogByPage(int current, int limit, QueryVo queryVo) {

        Blog blog = new Blog();
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<>();
                if (!StringUtils.isEmpty(queryVo.getTitle())) {
                    ps.add(cb.like(root.get("title"), "%" + queryVo.getTitle() + "%"));
                }
                if (queryVo.getCreateTime() != null && queryVo.getModifyTime() != null) {
                    ps.add(cb.between(root.get("createTime"), queryVo.getCreateTime(), queryVo.getModifyTime()));
                }
                if (!ObjectUtils.isEmpty(blog.getTags())) {
                    ps.add(cb.in(root.join("tags").get("id")).value(blog.getTags()));
                }
                if (!ObjectUtils.isEmpty(blog.getCategory())) {
                    ps.add(cb.in(root.join("category").get("category_id")).value(blog.getCategory().getName()));
                }
                return query.where(ps.toArray(new Predicate[ps.size()])).getRestriction();
            }
        }, PageRequest.of(current, limit));
    }

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Blog> getBlogByPage(Pageable pageable) {

        Page<Blog> page = blogRepository.findAll(pageable);
        page.stream().forEach(blog -> {
            Integer blogCommentCounts = commentRepository.countCommentsByBlog(blog);
            blog.setComments(blogCommentCounts);
        });
        return page;

    }
//    @Override
//    public List<Blog> getBlogByCategoryId(Long id) {
//
//        if (id == null) {
//            throw new CustomException(222, "The category ID cannot be empty");
//        }
//        return blogRepository.getBlogByCategory_Id(id);
//    }

    @Override
    public Blog getBlogDetailsByBlogId(Long blogId) {

        if (blogId == null) {
            throw new CustomException(222, "the Blog ID cannot be empty");
        }
        Blog blogEntity = blogRepository.getOne(blogId);

        Blog b = new Blog();
        BeanUtils.copyProperties(blogEntity,b);//复制先查询的blog到第二个blog的b对象
        if (b.getContent() != null) {
            b.setContent(MarkdownUtils.markdownToHtmlExtensions(b.getContent()));//处理文本内容
        }

        blogRepository.updateViews(blogId);
        return b;
    }

    @Override
    public List<Blog> getBlogBySort() {

        var sortedBlog = blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"));
        return sortedBlog.stream().limit(4).distinct().collect(Collectors.toList());
    }


    @Override
    public void saveBlog(BlogVo blogVo) {

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogVo, blog);

        CategoryVo categoryVo = blogVo.getCategory();
        Category category = new Category();
        if (categoryVo != null) {
            category.setId(categoryVo.getId());
            category.setName(categoryVo.getName());
            blog.setCategory(category);
        }

        List<TagVo> tagsVo = blogVo.getTags();
        if (tagsVo != null) {
            Set<Tag> collected = tagsVo.stream().map(tagVo -> {
                Tag tag = new Tag();
                tag.setId(tagVo.getId());
                tag.setName(tagVo.getName());
                return tag;
            }).collect(Collectors.toSet());
            blog.setTags(collected);
        }
        User user = new User();
        user.setId(1L);
        blog.setUser(user);
        blog.setComments(0);
        blog.setLikes(0);
        blog.setViews(0);
        blog.setCreateTime(new Date());
        blog.setModifyTime(new Date());
        blogRepository.save(blog);
    }


    @Transactional
    @Override
    public void deleteBlogById(Long id) {
        Blog blog = new Blog();
        blog.setId(id);
        commentRepository.deleteCommentByBlog(blog);
        blogRepository.deleteById(id);
    }
}
