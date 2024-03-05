package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sample.vo.Dept;
import com.sample.vo.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpCreateForm {
	private String name;
	private int deptNo;
	private String tel;
	private String email;
	private int salary;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	
	public Employee toEmp() {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setTel(tel);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		
		Dept dept = new Dept();
		dept.setNo(deptNo);
		emp.setDept(dept);
		return emp;
	}
}
