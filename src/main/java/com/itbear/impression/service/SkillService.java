package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.entities.vo.SkillVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SkillService {

    /**
     *  查询所有 SKill 数据，返回至index页面
     * @return {@link List<Skill>}
     */
    List<Skill> queryAll();

    /**
     *  获取所有技能列表
     * @return {@link List<Skill>}
     */
    List<Skill> findAll();

    Page<Skill> getSkillVoListByPage(Integer current, Integer limit, String name);

    Skill getSkillDetailById(Long skillId);

    void saveSkill(Skill skill); // 发布技能

    void deleteSkillById(Long skillId);
}
