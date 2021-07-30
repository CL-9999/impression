package com.itbear.impression.controller;

import com.itbear.impression.entities.pojo.Project;
import com.itbear.impression.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller(value = "projectController")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/project")
    public String project(Model model) {

        List<Project> projects = projectService.queryAll();
        List<Project> projectList = projects.stream()
                .distinct()
                .filter(project -> StringUtils.hasLength(project.getName())).collect(Collectors.toList());
        model.addAttribute("projects", projectList);

        return "project";
    }

    @GetMapping(path = "/pro-details")
    public String projectDetail() {

        return "project-details";
    }
}
