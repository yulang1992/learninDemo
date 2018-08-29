package com.edwin.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.edwin.java.entiy.Dept;


/**
 * [TODO]
 * @aothor EdwinYu
 * @date 时间 20182018年8月28日上午11:26:42
 */
@Mapper  //一定注意
public interface DeptDao {
   
   public List<Dept> findAll();
   
   public  Dept findById(Long id);
   
   public boolean addDept(Dept dept);
}
