package com.blog.boardback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings (CorsRegistry corsRegistry){
        // 모든 매핑 처리, 모든 메소드에 대해 cors 허용, 모든 출처 허용
        corsRegistry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins("*");
    }
}
