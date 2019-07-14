package com.example.demo.feignInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.JsonResult;
import com.example.demo.feignInterface.fallback.UserFeignClientFallbackFactory;

//@FeignClient(name="microservice-user", configuration=FeignLogConfiguration.class)
//@FeignClient(name="microservice-user", fallback=UserFeignClientFallback.class) // 这样没有Throwable，无法知道回退原因
@FeignClient(name="microservice-user", fallbackFactory=UserFeignClientFallbackFactory.class) // 有Throwable，可以知道回退原因
public interface UserFeignClient {
	
	@GetMapping(value = "/userList")
	JsonResult getUserList(
			@RequestParam(value="id", required=false) Long id,
			@RequestParam(value="name", required=false) String name);
	
}
