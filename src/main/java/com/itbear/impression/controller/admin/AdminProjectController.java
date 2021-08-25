package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.pojo.Project;
import com.itbear.impression.entities.pojo.Tag;
import com.itbear.impression.entities.vo.ProjectSaveVo;
import com.itbear.impression.entities.vo.ProjectVo;
import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-21 8:29:19 星期六
 * <p>
 * features：
 */
@RequestMapping(value = "admin/project")
@RestController
public class AdminProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping(path = "/page/{current}/{limit}")
    public Result page(@PathVariable(value = "current") Integer current,
                       @PathVariable(value = "limit") Integer limit) {

       Page<Project> page =  projectService.getProjectListByPage(current -1, limit);
        List<ProjectVo> collect = page.stream().map(project -> {
            ProjectVo projectVo = new ProjectVo();
            BeanUtils.copyProperties(project, projectVo);
            ArrayList<String> list = new ArrayList<>();
            project.getTag().forEach(item -> {
                String tagName = item.getName();
                list.add(tagName);
            });
            projectVo.setTags(list);

            projectVo.setUsername(project.getUser().getUsername());

            return projectVo;
        }).collect(Collectors.toList());

        return Result.ok().data("total", page.getTotalElements()).data("content", collect);
    }

    @DeleteMapping(path = "/del/{projectId}")
    public Result deleteProjectById(@PathVariable(value = "projectId") Long projectId) {

        projectService.deleteProjectById(projectId);
        return Result.ok();
    }

    @PostMapping(path = "/save")
    public Result save(@RequestBody ProjectSaveVo projectSaveVo) {

        projectService.saveProject(projectSaveVo);
        return Result.ok();
    }

    @GetMapping(path = "/info/{projectId}")
    public Result getProjectById(@PathVariable(value = "projectId") Long projectId) {

        Project project = projectService.getProjectDetailsByProjectId(projectId);
        return Result.ok().data("projectInfo", project);
    }
}
