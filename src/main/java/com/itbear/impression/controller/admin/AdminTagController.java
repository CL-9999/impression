package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.pojo.Tag;
import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.entities.vo.TagVo;
import com.itbear.impression.service.TagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-09 1:31:38 星期一
 * <p>
 * features：
 */
@RequestMapping(path = "/admin/tag")
@RestController
public class AdminTagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/list")
    public Result list() {
        List<TagVo> tagVoList = tagService.getAll();
        return Result.ok().data("tags", tagVoList);
    }
}
