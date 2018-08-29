
package com.edwin.java.service;

import java.util.List;

import com.edwin.java.entiy.Dept;

public interface DeptService {
    
	public List<Dept> findAll();

	public Dept findById(Long id);

	public boolean addDept(Dept dept);
}
