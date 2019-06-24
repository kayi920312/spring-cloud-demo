package com.example.demo.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.study.bean.JsonResult;
import com.example.demo.study.feignInterface.UserFeignClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("userController相关api")
@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@ApiOperation(value = "用户信息查询", notes="")
	@GetMapping(value = "/userList")
	public JsonResult getUserList(
			@ApiParam("id值") @RequestParam(value="id", required=false) Long id,
			@ApiParam("姓名") @RequestParam(value="name", required=false) String name) {
		
		try {
			JsonResult result = this.userFeignClient.getUserList(id, name);
			return result;
		} catch (Exception e) {
			LOGGER.error("error: " + e.toString());
			return new JsonResult(false, "失败: " + e.getMessage());
		}
	}
	
}
