package com.example.demo.feignInterface.fallback;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.bean.JsonResult;
import com.example.demo.feignInterface.UserFeignClient;

import feign.hystrix.FallbackFactory;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = Logger.getLogger(UserFeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable throwable) {
		return new UserFeignClient() {

			@Override
			public JsonResult getUserList(Long id, String name) {
				LOGGER.info(throwable);
				JsonResult result = new JsonResult();
				result.setSuccess(false);
				result.setMsg("请求失败！");
				return result;
			}
			
		};
	}

}
