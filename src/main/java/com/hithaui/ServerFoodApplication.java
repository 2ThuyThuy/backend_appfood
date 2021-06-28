package com.hithaui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.cloudinary.Cloudinary;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ServerFoodApplication {
	
		@Value("${cloudinary.url}")
		private String CLOUDINARY_URL;
		
		public static void main(String[] args) {
				SpringApplication.run(ServerFoodApplication.class, args);
		}
		
		@Bean
		public Cloudinary cloudinary() {
				Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
				return cloudinary;
		}
		
		@Bean
		CharacterEncodingFilter characterEncodingFilter() {
			CharacterEncodingFilter filter = new CharacterEncodingFilter();
			filter.setEncoding("UTF-8");
			filter.setForceEncoding(true);
			return filter;
		}
		
}
