package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "projectController")
public class ProjectController {

    @GetMapping(path = "/project")
    public String project() {

        return "project";
    }

    @GetMapping(path = "/pro-details")
    public String projectDetail() {

        return "project-details";
    }
}
