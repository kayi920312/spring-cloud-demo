package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.User;
import com.example.demo.common.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("userController相关api")
@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	private static final String USER_SERVICE_URL = "http://localhost:8081";
	private static final String GET_USERINFO = "/userList?";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ApiOperation(value = "用户信息查询", notes="")
	@GetMapping(value = "/userList")
	public JsonResult getUserList(
			@ApiParam("id值") @RequestParam(value="id", required=false) Long id,
			@ApiParam("姓名") @RequestParam(value="name", required=false) String name) {
		
		try {
			JsonResult result = restTemplate.getForObject(USER_SERVICE_URL + GET_USERINFO + "id=" + id + "&name=" + name, JsonResult.class);
			return result;
		} catch (Exception e) {
			LOGGER.error("error: " + e.toString());
			return new JsonResult(false, "失败: " + e.getMessage());
		}
	}
}
