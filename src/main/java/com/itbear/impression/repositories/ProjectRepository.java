package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 17:38:15 星期六
 * <p>
 * features：
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
