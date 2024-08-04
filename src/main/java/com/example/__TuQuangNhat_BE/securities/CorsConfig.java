package com.example.__TuQuangNhat_BE.securities;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "http://localhost:5173", //vue
                        "http://localhost:3000",  // ReactJS
                        "http://localhost:8081",  // React Native may minh
                        // dùng http://localhost:8082
                        "http://localhost:4200",  // Angular
                        "http://localhost:3001"   // Next.js
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}