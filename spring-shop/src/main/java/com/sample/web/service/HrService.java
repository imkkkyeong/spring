package com.sample.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DeptMapper;
import com.sample.mapper.EmployeeMapper;
import com.sample.vo.Dept;
import com.sample.vo.Employee;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;

@Service
public class HrService {
	
	@Autowired
	private DeptMapper deptMapper; 
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	// Dept 전체조회 
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts(); // 데이터베이스에서 부서정보조회한것을 서비스클래스에서 사용할 수 있게 반환.
	}

	// Dept등록
	public void createDept(DeptCreateForm deptCreateForm) { // 새로운 부서를 생성하기위한 정보를 담은 DeptCreateForm 객체가 파라미터
		Dept dept = new Dept();	// 데이터베이스에 추가할 새로운 부서를 저장하기 위해 Dept클래스 객체를 생성
		
		dept.setName(deptCreateForm.getName()); // deptCreateForm객체에서 이름을 꺼내와서 dept객체에 저장.
		dept.setTel(deptCreateForm.getTel());
		dept.setFax(deptCreateForm.getFax());
		deptMapper.insertDept(dept); //  데이터베이스에 dept객체의 저장하기 위해 deptMapper의 insertDept 메서드를 호출해서 dept 겍체 저장. 
		
	}
	
	// Emp 전체직원 조회
	public List<Employee> getAllEmps() {
		return employeeMapper.getAllEmps();// 데이터베이스에서 직원조회한것을 서비스클래스에서 사용할 수 있게 반환.
	}
	
	// Emp등록
	public void createEmp(EmpCreateForm empCreateForm) { // 새로운 직원을 저장하기 위해 정보를 담은 EmpCreateForm 객체가 파라미터
		Employee emp = new Employee();	// 데이터베이스에 추가할 새로운 부서를 저장하기 위해 Dept클래스 객체를 생성
			
		emp.setName(empCreateForm.getName());  // // EmpCreateForm객체에서 이름을 꺼내와서 emp객체에 저장.
		EmployeeMapper.insertEmp(emp); //  데이터베이스에 dept객체의 저장하기 위해 deptMapper의 insertDept 메서드를 호출해서 dept 겍체 저장. 
	}
	
	
	
	public Employee getEmpByNo(int no) {
	      Employee employee = employeeMapper.getEmpByNo(no);
	      
	      return employee;
	   }
}



//@Service : 해당 클래스를 빈으로 등록, 빈으로 등록된 클래스를 스프링이 컨테이너에 등록하여 필요한곳에 주입하거나 사용
/**
@Autowired : 스프링이 빈을 주입할때 사용. HrService가 인터페이스를 구현한 클래스 DeptMapper를 필요로함
(매퍼클래스 클래스에 의존성 주입해서 데이터베이스를 이용하려고 
 서비스 클래스는 직접적으로 데이터베이스에 접근하지 않고, 매퍼 클래스를 통해 간접적으로 데이터베이스를 사용가능)
**/