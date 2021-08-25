package com.itbear.impression.service.impl;

import com.itbear.impression.config.MarkdownUtils;
import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.pojo.Project;
import com.itbear.impression.entities.pojo.Tag;
import com.itbear.impression.entities.pojo.User;
import com.itbear.impression.entities.vo.CategoryVo;
import com.itbear.impression.entities.vo.ProjectSaveVo;
import com.itbear.impression.entities.vo.ProjectVo;
import com.itbear.impression.entities.vo.TagVo;
import com.itbear.impression.exception.CustomException;
import com.itbear.impression.repositories.ProjectRepository;
import com.itbear.impression.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 17:35:36 星期六
 * <p>
 * features：
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> queryAll() {

        return projectRepository.findAll();
    }

    @Override
    public Project getProjectDetailsByProjectId(Long projectId) {

        if (projectId == null) {
            throw new CustomException(222, "The project ID cannot be empty");
        }
        Project project = projectRepository.getOne(projectId);
        project.setContent(MarkdownUtils.markdownToHtmlExtensions(project.getContent()));
        return project;
    }

    @Override
    public Page<Project> getProjectListByPage(Integer current, Integer limit) {

        Page<Project> page = projectRepository.findAll(PageRequest.of(current, limit));
//        page.forEach(project -> {
//            ProjectVo projectVo = new ProjectVo();
//            BeanUtils.copyProperties(project, projectVo);
//
//            projectVo.setUsername(project.getUser().getUsername());
//            List<Tag> tag = project.getTag();
//            tag.forEach(item -> {
//                ArrayList<String> list = new ArrayList<>();
//                list.add(item.getName());
//
//                projectVo.setTags(list);
//            });
//        });
        return page;
    }

    @Override
    public void deleteProjectById(Long projectId) {

        projectRepository.deleteById(projectId);
    }

    @Override
    public void saveProject(ProjectSaveVo projectSaveVo) {

        Project project = new Project();
        BeanUtils.copyProperties(projectSaveVo, project);

        CategoryVo categoryVo = projectSaveVo.getCategory();
        Category category = new Category();
        if (categoryVo != null) {
            category.setId(categoryVo.getId());
            category.setName(categoryVo.getName());
            project.setCategory(category);
        }
        List<TagVo> tagsVo = projectSaveVo.getTag();
        if (tagsVo != null) {
            List<Tag> collected = tagsVo.stream().map(tagVo -> {
                Tag tag = new Tag();
                tag.setId(tagVo.getId());
                tag.setName(tagVo.getName());
                return tag;
            }).collect(Collectors.toList());
            project.setTag(collected);
        }
        project.setCreateTime(new Date());
        project.setModifyTime(new Date());
        User user = new User();user.setId(1L);
        project.setUser(user);
        projectRepository.save(project);
    }
}
