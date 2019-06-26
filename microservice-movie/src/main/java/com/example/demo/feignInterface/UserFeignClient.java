package com.example.demo.feignInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.JsonResult;

//@FeignClient(name="microservice-user", configuration=FeignLogConfiguration.class)
@FeignClient(name="microservice-user")
public interface UserFeignClient {
	
	@GetMapping(value = "/userList")
	JsonResult getUserList(
			@RequestParam(value="id", required=false) Long id,
			@RequestParam(value="name", required=false) String name);
	
}
