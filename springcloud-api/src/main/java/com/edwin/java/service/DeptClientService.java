package com.edwin.java.service;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edwin.java.callback.DeptClientServiceFallBackFactory;
import com.edwin.java.entiy.Dept;

/**
 * Description :[TODO]
 * @aothor EdwinYu
 * @date 2018年8月29日
 */
@FeignClient(value="SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory=DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id")Long id);
	
	@RequestMapping(value="/dept/findAll",method=RequestMethod.GET)
	public List<Dept> findAll();
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(Dept dept);
}
