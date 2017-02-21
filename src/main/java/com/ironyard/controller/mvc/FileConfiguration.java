package com.ironyard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by rohanayub on 2/14/17.
 */
@Configuration
public class FileConfiguration extends WebMvcConfigurerAdapter{
    @Value("${upload.location}")
    private String uploadedFile;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/ourCoolUploadedFiles/**")
                .addResourceLocations("file:"+uploadedFile);
    }

}
