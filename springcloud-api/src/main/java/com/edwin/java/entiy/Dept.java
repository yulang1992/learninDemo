
package com.edwin.java.entiy;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * [TODO]
 * @aothor EdwinYu
 * @date 时间 20182018年8月28日上午10:42:37
 */
//@Setter
//@Getter
//@Data  //Setter Getter
//@ToString
//@NoArgsConstructor
//@Accessors(chain=true) //开启链式编程
public class Dept implements Serializable {
	
	private static final long serialVersionUID = -1412411212616341445L;
	
	private Long deptNo; //部门编号
	private String dName; //部门名称
	private String dbSource; //部门来源  数据库名称


	public Long getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	public String getDbSource() {
		return dbSource;
	}
	
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + dName + ", dbSource=" + dbSource + "]";
	}
  

}
