package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-05 17:47:19 星期四
 * <p>
 * features：
 */
@RestController
public class UserController {

    @GetMapping(path = "/user/info")
    public Result user() {

        return Result.ok().data("userInfo", "users").data("token", "token");
    }

    @PostMapping(path = "/auth/2step-code")
    public Result userCode() {

        return Result.ok().data("2step-code", "111").data("code", "code");
    }


}
