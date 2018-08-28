package com.edwin.java.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.edwin.java.dao.DeptDao;
import com.edwin.java.entiy.Dept;
import com.edwin.java.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
   
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}
	@Override
	public Dept findById(Long id) {
		Assert.isTrue(null!=id, "id参数不能为空！");
		return deptDao.findById(id);
	}

	@Override
	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

}
