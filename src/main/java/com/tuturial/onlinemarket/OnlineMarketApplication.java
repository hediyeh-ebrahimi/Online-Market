package com.tuturial.onlinemarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class OnlineMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketApplication.class, args);
	}

//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		/*System.out.println("Configuration file has taken effect");*/
//		System.out.println("----------16------------");
//		registry.addResourceHandler("/static/image/**")
//				.addResourceLocations("file:F:\\java-tutorial\\online-market\\src\\main\\resources\\static\\image\\");
//	}
}
