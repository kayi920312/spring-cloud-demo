package com.example.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.common.JsonResult;
import com.example.demo.service.impl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("userController相关api")
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "UserServiceImpl")
	private UserServiceImpl userService;
	
	@ApiOperation(value = "用户信息查询", notes="")
	@GetMapping(value = "/userList")
	public JsonResult getUserList(
			@ApiParam("id值") @RequestParam(value="id", required=false) Long id,
			@ApiParam("姓名") @RequestParam(value="name", required=false) String name) {
		
		try {
			User userParam = new User();
			if (id != null) {
				userParam.setId(id);
			}
			if (name != null && !"".equals(name) && !"null".equals(name)) {
				userParam.setName(name);
			}
			return new JsonResult(userService.getUserList(userParam));
		} catch (Exception e) {
			LOGGER.error("error: " + e.toString());
			return new JsonResult(false, "失败: " + e.getMessage());
		}
	}
}
