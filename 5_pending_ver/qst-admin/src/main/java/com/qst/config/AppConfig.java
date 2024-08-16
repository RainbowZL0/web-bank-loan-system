package com.qst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AppConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        // 进行相应的配置，例如设置上传文件的最大大小、临时文件存储位置等
        multipartResolver.setMaxUploadSize(1024 * 1024 * 1024); // 设置最大上传文件大小为 1MB

        return multipartResolver;
    }
}