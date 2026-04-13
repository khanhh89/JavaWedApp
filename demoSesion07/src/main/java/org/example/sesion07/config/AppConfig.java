package org.example.sesion07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.sesion07")
// Cần implement WebMvcConfigurer để cấu hình tài nguyên tĩnh (ảnh, css, js)
public class AppConfig implements WebMvcConfigurer {

    // 1. Cấu hình Resource Handlers - CỰC KỲ QUAN TRỌNG ĐỂ HIỆN ẢNH
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ánh xạ link ảo /external-img/ vào thư mục thật trên ổ D
        registry.addResourceHandler("/external-img/**")
                .addResourceLocations("file:///D:/Dowload/");

        // Cấu hình cho các file tĩnh trong project (nếu có dùng css/js/img trong webapp)
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    // 2. Bean SpringResourceTemplateResolver
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 3. Bean SpringTemplateEngine
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    // 4. Bean ThymeleafViewResolver
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 5. Bean xử lý Multipart (Upload file)
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}