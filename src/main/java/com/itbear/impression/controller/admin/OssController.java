package com.itbear.impression.controller.admin;

import com.itbear.impression.entities.vo.Result;
import com.itbear.impression.exception.CustomException;
import com.itbear.impression.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-16 2:11:50 星期一
 * <p>
 * features：
 */
@RequestMapping(path = "oss/file")
@RestController
public class OssController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/upload")
    public Result upload(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "module", required = false) String module)  {
        // 获取文件名称
        String filename = file.getOriginalFilename();
        try {
            String url = fileService.upload(file.getInputStream(), module, filename);

            return Result.ok().data("url",url).message("文件上传成功");
        } catch (IOException e) {
            throw new CustomException(222, e.getMessage());
        }
    }
}
