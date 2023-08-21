 package com.f5Events.gametour.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@Configuration
/* @EnableWebMvc */
public class WebConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowCredentials(false)
            .allowedOrigins("*")
            .allowedMethods("GET","POST","PUT","DELETE");
    }
}
