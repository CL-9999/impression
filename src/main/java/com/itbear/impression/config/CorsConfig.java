package com.itbear.impression.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-03 17:33:56 星期二
 * <p>
 *  features：该类用于处理前端跨域问题
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("Access-Control-Allow-Origin", "*")
                .allowedHeaders("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE")
                .allowedHeaders("Access-Control-Allow-Methods", "*")
                .allowedHeaders("Access-Control-Allow-Credentials", "*")
                .allowedOrigins("*")
                .allowedHeaders("Access-Control-Allow-Headers", "")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600)
                .allowedHeaders("*");
    }
}

