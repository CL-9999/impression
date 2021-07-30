package com.itbear.impression;

import com.itbear.impression.entities.pojo.Skill;
import com.itbear.impression.repositories.SkillRepository;
import com.itbear.impression.service.SkillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-21 18:13:59 星期三
 * <p>
 * features：
 */
@SpringBootTest
public class SkillTest {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void queryAll() {

        List<Skill> skills = skillRepository.findAll();
        System.out.println(skills);
    }

}
