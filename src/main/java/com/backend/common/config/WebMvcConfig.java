package com.backend.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정 적용
                .allowedOrigins("*") // 허용할 오리진(도메인) 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드 설정
                .allowedHeaders("*"); // 허용할 헤더 설정
    }
}
