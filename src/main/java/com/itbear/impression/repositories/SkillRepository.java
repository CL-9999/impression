package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * features：{@link Skill} 实体类数据持久层。
 */
public interface SkillRepository extends JpaRepository<Skill, Long>, JpaSpecificationExecutor<Skill> {


}
