package com.example.demo.ribbonconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Ribbon局部config
 * @author kaiying.chen
 */
@Configuration
public class UserRibbonClientConfig {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
