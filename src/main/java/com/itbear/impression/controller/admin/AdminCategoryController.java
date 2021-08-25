package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.pojo.Category;
import com.itbear.impression.entities.vo.CategoryVo;
import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-09 0:05:18 星期一
 * <p>
 * features：
 */
@RequestMapping(path = "/admin/category")
@RestController
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public Result list() {

      List<CategoryVo> categoryList = categoryService.getAll();
      return Result.ok().data("categories", categoryList);
    }
}
