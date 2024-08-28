package com.minister.visitorsapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootTest
class VisitorsappApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		SpringApplication.run(VisitorsappApplicationTests.class, args);
	}
	  @Bean
	    public WebMvcConfigurer configure() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry reg) {
	                reg.addMapping("/**")
	                   .allowedOrigins(
	                       "http://localhost:3000",
	                       "http://localhost",
	                       "http://localhost:8080"
	                      	                   )
	                   .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
	                   .allowedHeaders("*")
	                   .allowCredentials(true);
	            }
	        };
	  
	 }
}
