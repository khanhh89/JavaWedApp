package org.example.bt5;

import org.example.bt5.model.SystemConfig.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class Main {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(SystemConfig.class);
            SystemConfig config = context.getBean(SystemConfig.class);
            config.display();
        }
    }