package com.minister.visitorsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VisitorsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorsappApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry reg) {
                reg.addMapping("/**")
                   .allowedOrigins(
                       "http://localhost:3000",
                       "https://mumbailocal.org/visitorsapp",
                       "http://mumbailocal.org/visitorsapp",
                       "https://mumbailocal.org/"
                   )
                   .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                   .allowedHeaders("*")
                   .allowCredentials(true);
            }
        };
  
 }

}
