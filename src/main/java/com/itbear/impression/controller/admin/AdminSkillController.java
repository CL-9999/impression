package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.entities.vo.SkillVo;
import com.itbear.impression.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-07-31 3:59:45 星期六
 * <p>
 * features：
 */
@RequestMapping(value = "admin/skill")
@RestController(value = "adminSkillController")
public class AdminSkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(path = "/page/{current}/{limit}")
    public Result page(@PathVariable(value = "current") Integer current,
                       @PathVariable(value = "limit") Integer limit,
                       @RequestParam(value = "name", required = false) String name) {

        Page<Skill> page = skillService.getSkillVoListByPage(current - 1, limit, name);
        List<Skill> content = page.getContent();
        List<SkillVo> collect = content.stream().map(skill -> {
            SkillVo skillVo = new SkillVo();
            BeanUtils.copyProperties(skill, skillVo);
            List<String> list = new ArrayList<>();
            list.add(skill.getTagOne());
            list.add(skill.getTagTwo());
            list.add(skill.getTagThree());
            list.add(skill.getTagFour());
            list.add(skill.getTagFive());
            skillVo.setTags(list);
            skillVo.setUsername(skill.getUser().getUsername());
            return skillVo;
        }).collect(Collectors.toList());
        return Result.ok().data("total", page.getTotalElements()).data("content", collect);
    }

    @PostMapping(path = "/save")
    public Result saveSkill(@RequestBody Skill skill) {

        skillService.saveSkill(skill);
        return Result.ok();
    }

    @DeleteMapping(path = "/del/{skillId}")
    public Result deleteSkillById(@PathVariable(value = "skillId") Long skillId) {
        skillService.deleteSkillById(skillId);
        return Result.ok();
    }

    @GetMapping(path = "/info/{id}")
    public Result getSkillInfoById(@PathVariable(value = "id") Long id) {

        Skill skillInfo = skillService.getSkillDetailById(id);
        return Result.ok().data("skillInfo", skillInfo);
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }
}
