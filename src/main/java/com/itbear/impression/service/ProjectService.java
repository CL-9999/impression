package com.itbear.impression.service;

import com.itbear.impression.entities.pojo.Project;
import com.itbear.impression.entities.vo.ProjectSaveVo;
import com.itbear.impression.entities.vo.ProjectVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-24 17:34:54 星期六
 * <p>
 * features：
 */
public interface ProjectService {

    List<Project> queryAll();

    /**
     *  根据project实体id查询Project数据
     * @param projectId id值
     */
    Project getProjectDetailsByProjectId(Long projectId);

    Page<Project> getProjectListByPage(Integer current, Integer limit);

    void deleteProjectById(Long projectId);

    void saveProject(ProjectSaveVo projectSaveVo);
}
