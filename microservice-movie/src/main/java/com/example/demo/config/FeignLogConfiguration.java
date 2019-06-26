package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;

public class FeignLogConfiguration {
	
	@Bean
	Logger.Level feignLogger() {
		return Logger.Level.FULL;
	}
}
