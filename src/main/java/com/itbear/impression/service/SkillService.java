package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Skill;

import java.util.List;

public interface SkillService {

    /**
     *  查询所有 SKill 数据
     * @return {@link List<Skill>}
     */
    List<Skill> queryAll();
}