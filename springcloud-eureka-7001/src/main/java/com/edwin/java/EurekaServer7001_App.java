package com.edwin.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description :[Eureka服务启动类]
 * @aothor EdwinYu
 * @date 2018年8月28日
 */
@SpringBootApplication
@EnableEurekaServer  //开启Eureka服务，接收其他服务注册进来
public class EurekaServer7001_App {

	public static void main(String[] args) {
       SpringApplication.run(EurekaServer7001_App.class, args);
	}

}
