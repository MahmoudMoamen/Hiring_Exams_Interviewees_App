package com.webApp;

import com.webApp.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    @Bean
    public WebApplicationContext springApplicationContext(){
        return new WebApplicationContext();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "AppProperties")
    public AppProperties getAppProperties(){
        return new AppProperties();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH")
                        .allowedHeaders("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
                                "Access-Control-Request-Method", "Authorization", "Access-Control-Request-Headers", "Origin",
                                "Cache-Control", "Content-Type")
                        .allowCredentials(false);
            }
        };
    }

}
