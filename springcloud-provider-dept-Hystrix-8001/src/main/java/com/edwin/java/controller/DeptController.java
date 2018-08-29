package com.edwin.java.controller;

import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.edwin.java.entiy.Dept;
import com.edwin.java.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Description :[部门管理业务]
 * @aothor EdwinYu
 * @date 2018年8月28日
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
   
	private static final Logger logger =LoggerFactory.getLogger(DeptController.class);
	
	/**
	 * 服务发现服务
	 */
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping("/findAll")
	public List<Dept> idnex() {
	  List<Dept> list = deptService.findAll();
	  return list;
	}
	
	
	/**
	 * 一旦调用服务方法失败并抛出异常错误信息后，会自动调用
	 * @HystrixCommand 标注好的fallbackMethod 调用类中的制定方法
	 */
	@GetMapping(value="/get/{id}")
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept getId(@PathVariable("id")Long id) {
	  Dept dept= deptService.findById(id);
	  if(null ==dept) {
		  throw new RuntimeException("该id："+id+" ,没有对应的信息!!!!");
	  }
	  return dept;
	}
	
	@PostMapping(value="/add")
	public boolean add(Dept dept) {
 	  return deptService.addDept(dept);
	}
	
	@RequestMapping(value="/discovery",method=RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		logger.info("*********" + list);
		List<ServiceInstance> serlist = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
		for(ServiceInstance ints:serlist) {
		  logger.info(ints.getServiceId() +"\t" + ints.getHost() +"\t" + ints.getPort() +"\t" +ints.getUri());
		}
		return this.discoveryClient;
	}
	
	public Dept processHystrix_Get(@PathVariable("id")Long id) {
		Dept dept=new Dept();
		dept.setDeptNo(id);
		dept.setdName("该id："+id+"没有对应的信息，null -- @@HystrixCommand");
		dept.setDbSource("no this database in MySql");
       return dept;		
	}
}
