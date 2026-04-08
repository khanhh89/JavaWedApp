package org.example.sesion04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// đánh dấu là lớp cấu hình
@Configuration
// bật chế độ wed mvc
@EnableWebMvc
// quét các bean đang cần được khởi tạo
@ComponentScan(basePackages = "org.example.sesion04")
public class AppConfig  {
    // cấu hình bean ViewResolver để đọc được view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //cấu hình tiền tố
        viewResolver.setPrefix("/WEB-INF/views/");
        //cấu hình hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
