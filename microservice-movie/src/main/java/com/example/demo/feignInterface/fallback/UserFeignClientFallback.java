package com.example.demo.feignInterface.fallback;

import org.springframework.stereotype.Component;

import com.example.demo.bean.JsonResult;
import com.example.demo.feignInterface.UserFeignClient;

@Component
public class UserFeignClientFallback implements UserFeignClient{

	@Override
	public JsonResult getUserList(Long id, String name) {
		JsonResult result = new JsonResult();
		result.setSuccess(false);
		result.setMsg("请求失败！");
		return result;
	}

}
