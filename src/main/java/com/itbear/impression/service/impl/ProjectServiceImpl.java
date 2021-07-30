package com.itbear.impression.service.impl;

import com.itbear.impression.entities.pojo.Project;
import com.itbear.impression.repositories.ProjectRepository;
import com.itbear.impression.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
