package com.edwin.irule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.loadbalancer.IRule;

/**
 * Description :[自定义负载均衡算发]
 * @aothor EdwinYu
 * @date 2018年8月29日
 */
@Configuration
public class MySelfRule{
 
	@Bean
	public IRule myRule() {
		//return new RandomRule();// Ribbon默认是轮询，我自定义为随机
		//return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
		return new MyRandomRule();   //每次每台机器5次
	}

}
