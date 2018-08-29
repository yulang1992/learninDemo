package com.edwin.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.edwin.java"})
@ComponentScan("com.edwin.java")
public class DeptConsumerFeign_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign_App.class, args);
	}
}
