package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Employee;


@Mapper
public interface EmployeeMapper {

	List<Employee> getAllEmps();

	Employee getEmpByNo(int no);

	void insertEmp(Employee emp); 
}


/**
@mapper 설정
class가 아닌 interface
모든 정보를 받아 올꺼니까 리스트 타입
**/