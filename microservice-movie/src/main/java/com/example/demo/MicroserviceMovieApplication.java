package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard // 如果要用 HystrixDashboard 就必须配
@EnableCircuitBreaker // 如果要用 HystrixDashboard 就必须配
public class MicroserviceMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMovieApplication.class, args);
	}

}
