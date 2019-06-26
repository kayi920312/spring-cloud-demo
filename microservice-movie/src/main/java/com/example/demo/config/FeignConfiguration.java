package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import feign.Contract;

//@Configuration 不需要写这个注解，如果要写，则这个类不能在主函数上下文中
public class FeignConfiguration {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}
