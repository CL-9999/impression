package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-21 18:10:30 星期三
 * <p>
 * features：{@link Skill} 实体类数据持久层。
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {


}
