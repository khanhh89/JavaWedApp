package org.example.sesion05.bt1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class Wedconfig {
    @Bean
    public SpringResourceTemplateResolver templateResolver (){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/template/");  // views
        templateResolver.setSuffix(".html");   // .jsp
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    @Bean public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
}
