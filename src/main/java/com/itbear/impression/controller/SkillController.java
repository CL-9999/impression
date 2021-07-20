package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "skillController")
public class SkillController {

    @GetMapping(value = "/skill")
    public String skill() {

        return "skill";
    }

    @GetMapping(value = "/skill-details")
    public String detail() {

        return "skill-details";
    }
}
