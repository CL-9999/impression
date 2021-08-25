package com.itbear.impression.service.impl;

import com.itbear.impression.config.MarkdownUtils;
import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.entities.pojo.User;
import com.itbear.impression.entities.vo.SkillVo;
import com.itbear.impression.exception.CustomException;
import com.itbear.impression.repositories.SkillRepository;
import com.itbear.impression.repositories.UserRepository;
import com.itbear.impression.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
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
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findAll() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Page<Skill> getSkillVoListByPage(Integer current, Integer limit, String name) {

        return skillRepository.findAll(new Specification<Skill>() {
            @Override
            public Predicate toPredicate(Root<Skill> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> ps = new ArrayList<>();
                if (!StringUtils.isEmpty(name)) {
                    ps.add(cb.like(root.get("name"),"%" + name + "%"));
                }
                return query.where(ps.toArray(new Predicate[ps.size()])).getRestriction();
            }
        }, PageRequest.of(current, limit));
    }

    @Override
    public Skill getSkillDetailById(Long skillId) {

        if (skillId == null) {
            throw new CustomException(222, "id不能为空");
        }

        Skill skill = skillRepository.getOne(skillId);
        if (skill.getContent() != null) {
            skill.setContent(MarkdownUtils.markdownToHtmlExtensions(skill.getContent()));
        }
        return skill;
    }

    @Override
    public void saveSkill(Skill skill) {

        skill.setCreateTime(new Date());
        skill.setModifyTime(new Date());
        User user = new User();
        user.setId(1L);
        skill.setUser(user);
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkillById(Long skillId) {

        skillRepository.deleteById(skillId);
    }
}
