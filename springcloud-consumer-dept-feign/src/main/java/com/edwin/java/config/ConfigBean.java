package com.edwin.java.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean // boot -->spring applicationContext.xml --- @Configuration配置 ConfigBean =
						// applicationContext.xml
{
	/**
	 * Description: @LoadBalanced 默认轮询算发
	 * 
	 * @aothor EdwinYu
	 * @date 2018年8月29日
	 */
	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * Description: [自定义负载均衡算发规则]
	 * @aothor EdwinYu
	 * @date 2018年8月29日
	 */
	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();  //轮询算发
		// return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
		return new RetryRule();
	}
}

// @Bean
// public UserServcie getUserServcie()
// {
// return new UserServcieImpl();
// }
// applicationContext.xml == ConfigBean(@Configuration)
// <bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">