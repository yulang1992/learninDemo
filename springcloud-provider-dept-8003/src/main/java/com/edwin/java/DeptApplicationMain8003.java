package com.edwin.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description :[TODO]
 * @aothor EdwinYu
 * @date 2018年8月28日
 */
@SpringBootApplication
@EnableEurekaClient   //本服务启动后会自动注册进Eureka服务中
@EnableDiscoveryClient   //服务发现
public class DeptApplicationMain8003 {

	public static void main(String[] args) {
        SpringApplication.run(DeptApplicationMain8003.class, args);
	}

}
