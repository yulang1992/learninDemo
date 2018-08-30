package com.edwin.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001_APP {

	/**
	 * Description: [TODO]
	 * @aothor EdwinYu
	 * @date 2018年8月30日
	 */
	public static void main(String[] args) {
      SpringApplication.run(ConsumerHystrixDashboard9001_APP.class, args);
	}

}
