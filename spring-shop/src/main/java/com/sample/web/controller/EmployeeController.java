package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sample.vo.Employee;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.service.HrService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private HrService hrService;
	
	@GetMapping("/list")  // "/employee/list"로 들어오는 GET 요청이 발생하면 list() 메서드가 실행
	public String list(Model model) { 
		
		List<Employee> empList = hrService.getAllEmps(); // empService를 호출해서 모든 정보를 불러와 empList에 담는다.
		model.addAttribute("empList", empList); //  empList를 model객체에 추가한다(attribute)/(키(속성이름), 값(실제 데이터)) 이 데이터를 view에서 참조 
		return "emp/list"; // "WEB-INF/views/emp/list.jsp"로 내부 이동
	}
	
	@GetMapping("/create") 
	public String form(Model model) {
		List<Employee> empList = hrService.getAllEmps(); // 
		model.addAttribute("empList", empList);
		return "emp/form"; // "WEB-INF/views/emp/form.jsp"로 내부 이동
		
	}
	
	@PostMapping("/create") 
	public String create(EmpCreateForm empCreateForm) {  // DeptCreateFrom객체를 파라미터로 받는다. (form에서 작성한 정보)
	  hrService.createEmp(empCreateForm); // hrService에서 createDept메서드(deptCreateForm 정보가 담겨있음)를 호출한다. 
		
		return "redirect:list"; // 목록을 보여주는 페이지로 리다이렉션
		
	}
	@GetMapping(path = "/detail")
	   public String detail(int no, Model model) {
	      Employee employee = hrService.getEmpByNo(no);
	      model.addAttribute("emp", employee);
	      
	      return "emp/detail";
	   }
	

	
}
