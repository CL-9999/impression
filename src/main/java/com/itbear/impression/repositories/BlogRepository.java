package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.Blog;
import com.itbear.impression.entities.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> getBlogByCategory_Id(Long categoryId);
}
