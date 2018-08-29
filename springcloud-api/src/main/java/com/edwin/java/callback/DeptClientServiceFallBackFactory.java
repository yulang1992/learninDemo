package com.edwin.java.callback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edwin.java.entiy.Dept;
import com.edwin.java.service.DeptClientService;

import feign.hystrix.FallbackFactory;

/**
 * Description :[TODO]
 * @aothor EdwinYu
 * @date 2018年8月29日
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public Dept get(Long id) {
				Dept dept =new Dept();
				dept.setDeptNo(id);
				dept.setdName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				dept.setDbSource("no this database in MySQL");
				return dept;
			}
			
			@Override
			public List<Dept> findAll() {
				return null;
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
