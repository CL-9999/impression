package com.itbear.impression.service.impl;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.repositories.SkillRepository;
import com.itbear.impression.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> queryAll() {

        var skills = skillRepository.findAll();

        return skills.stream()
                .limit(3)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findAll() {
        List<Skill> skills = skillRepository.findAll();
        List<Skill> collected = skills.stream().distinct().collect(Collectors.toList());
        return collected;
    }
}
