package com.zzkk.soccer_video.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName urlConfig
 * @Description
 * @date 2023/1/17 13:23
 * @Version 1.0
 */
@Configuration
public class urlConfig implements WebMvcConfigurer {
    /*
     *addResourceHandler:访问映射路径
     *addResourceLocations:资源绝对路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myvideos/**").addResourceLocations("file:D:/dataset/video_upload/");
    }
}
