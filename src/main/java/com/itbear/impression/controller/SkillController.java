package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.repositories.SkillRepository;
import com.itbear.impression.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "skillController")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(value = "/skill")
    public String skill(Model model) {
        List<Skill> skills = skillService.findAll();
        model.addAttribute("skills", skills);
        return "skill";
    }

    @GetMapping(path = "/skill/{skillId}/details")
    public String skillDetail(@PathVariable(value = "skillId") Long skillId, Model model) {

        var skill =  skillService.getSkillDetailById(skillId);
        model.addAttribute("skills", skill);

        List<Skill> skills = skillService.queryAll();
        model.addAttribute("skillList", skills);
        return "skill-details";
    }

}
