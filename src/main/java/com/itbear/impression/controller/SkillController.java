package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.repositories.SkillRepository;
import com.itbear.impression.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/skill-details")
    public String detail() {

        return "skill-details";
    }

}
