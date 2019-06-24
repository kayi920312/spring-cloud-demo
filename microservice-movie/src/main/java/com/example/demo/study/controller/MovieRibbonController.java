package com.example.demo.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ribbonconfig.UserRibbonClientConfig;
import com.example.demo.study.bean.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("userController相关api")
@RestController
@RibbonClient(name="microservice-user", configuration=UserRibbonClientConfig.class)
@RequestMapping("/ribbon")
public class MovieRibbonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieRibbonController.class);
//	private static final String USER_SERVICE_URL = "http://localhost:8081";
	private static final String USER_SERVICE_URL_BALANCE = "http://microservice-user";
	private static final String GET_USERINFO = "/userList?";
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@ApiOperation(value = "用户信息查询", notes="")
	@GetMapping(value = "/userList")
	public JsonResult getUserList(
			@ApiParam("id值") @RequestParam(value="id", required=false) Long id,
			@ApiParam("姓名") @RequestParam(value="name", required=false) String name) {
		
		try {
			JsonResult result = restTemplate.getForObject(USER_SERVICE_URL_BALANCE + GET_USERINFO + "id=" + id + "&name=" + name, JsonResult.class);
			return result;
		} catch (Exception e) {
			LOGGER.error("error: " + e.toString());
			return new JsonResult(false, "失败: " + e.getMessage());
		}
	}
	
	@ApiOperation(value = "测试Ribbon", notes="")
	@GetMapping(value = "/log-user-instance")
	public void getLogUserInstance() {
		
		try {
			ServiceInstance userInstance = this.loadBalancerClient.choose("microservice-user");
			LOGGER.info(userInstance.getHost() + ": " + userInstance.getPort());
		} catch (Exception e) {
			LOGGER.error("error: " + e.toString());
		}
	}
}
