package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Dept;



@Mapper
public interface DeptMapper {
 
	List<Dept> getAllDepts();  // 부서정보 조회

	void insertDept(Dept dept); // 새로운 부서 정보 저장
	
}
