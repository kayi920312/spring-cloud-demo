//package com.example.demo.ribbonconfig;
////package com.example.demo.config;
////
////import org.springframework.cloud.netflix.ribbon.RibbonClients;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////
////import com.netflix.client.config.IClientConfig;
////import com.netflix.loadbalancer.ConfigurationBasedServerList;
////import com.netflix.loadbalancer.IPing;
////import com.netflix.loadbalancer.IRule;
////import com.netflix.loadbalancer.PingUrl;
////import com.netflix.loadbalancer.RandomRule;
////import com.netflix.loadbalancer.Server;
////import com.netflix.loadbalancer.ServerList;
////import com.netflix.loadbalancer.ServerListSubsetFilter;
////
/////**
//// * Ribbon全局config
//// * @author kaiying.chen
//// *
//// */
////@Configuration
////@RibbonClients(defaultConfiguration=DefaultConfiguration.class)
////public class UserRibbonClientsConfig {
////	public static class BazServiceList extends ConfigurationBasedServerList {
////		public BazServiceList(IClientConfig config) {
////			super.initWithNiwsConfig(config);
////		}
////	}
////}
////
////@Configuration
////class DefaultConfiguration {
////	
////	@Bean
////	public IRule ribbonRule() {
////		return new RandomRule();
////	}
////	
////	@Bean
////	public IPing ribbonPing() {
////		return new PingUrl();
////	}
////	
////	@Bean
////	public ServerList<Server> ribbonServerList(IClientConfig config) {
////		return new UserRibbonClientsConfig.BazServiceList(config);
////	}
////	
////	@Bean
////	public ServerListSubsetFilter serverListFilter() {
////		ServerListSubsetFilter filter = new ServerListSubsetFilter();
////		return filter;
////	}
////}
