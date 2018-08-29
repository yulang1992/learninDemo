package com.edwin.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edwin.java.entiy.Dept;
import com.edwin.java.service.DeptClientService;

/**
 * Description :[TODO]
 * @aothor EdwinYu
 * @date 2018年8月28日
 */
@RestController
public class DeptController_Consumer {
    
	@Autowired
	private DeptClientService deptClientService;
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept)
	{
		return deptClientService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return deptClientService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/findAll")
	public List<Dept> list()
	{
		return deptClientService.findAll();
	}

}
