package com.pedromaironi.apicrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCrudApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("GET", "POST", "PUT", "DELETE")
//						.allowedHeaders("*");
//			}
//		};
//	}
}
