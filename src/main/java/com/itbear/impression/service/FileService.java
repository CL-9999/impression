package com.itbear.impression.service;

import java.io.InputStream;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-16 2:20:16 星期一
 * <p>
 * features：
 */
public interface FileService {

    public String upload(InputStream inputStream, String module, String fileName);
}
