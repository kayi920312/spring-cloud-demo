package com.example.demo.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Ribbon局部config
 * @author kaiying.chen
 */
@Configuration
@RibbonClient(name="microservice-user", configuration=UserRibbonConfig.class)
public class UserRibbonClientConfig {}

@Configuration
class UserRibbonConfig {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
