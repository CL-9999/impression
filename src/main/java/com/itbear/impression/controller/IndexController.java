package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Bear
 * @site：https://www.yuque.com/bearpess
 * @email：bearpess@gmail.com
 * @created 2021-07-19 19:37:23 星期一
 * <p>
 * features：
 */
@Controller(value = "indexController")
public class IndexController {

    private final static String INDEX = "index";

    @GetMapping(path = "/index")
    public String toIndex() {

        return INDEX;
    }
}

