package com.zzkk.soccer_video;

import com.zzkk.soccer_video.mapper.VideoUploadMapper;
import com.zzkk.soccer_video.pojo.VideoUpload;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@SpringBootApplication
@MapperScan("com.zzkk.soccer_video")
public class SoccerVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerVideoApplication.class, args);
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.parse("800MB")); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("800MB"));
        return factory.createMultipartConfig();
    }


}
