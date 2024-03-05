package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.vo.Company;
import com.sample.vo.Dept;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.ProductCreateForm;
import com.sample.web.service.HrService;

@Controller  //get 요청을 처리하는 컨트롤러 
@RequestMapping("/dept")  // "/dept"로 시작하는 모든 요청을 이 컨트롤러에 매핑
public class DeptController {
	
	@Autowired // HrService에 의존성 주입 
	private HrService hrService;
	
	
	@GetMapping("/list")  // "/dept/list"로 들어오는 GET 요청이 발생하면 list() 메서드가 실행
	public String list(Model model) { 
		
		List<Dept> deptList = hrService.getAllDepts(); // hrService를 호출해서 모든 정보를 불러와 deptList에 담는다.
		model.addAttribute("deptList", deptList); //  deptList를 model객체에 추가한다(attribute)/(키(속성이름), 값(실제 데이터)) 이 데이터를 view에서 참조 
		return "dept/list"; // "WEB-INF/views/dept/list.jsp"로 내부 이동
	}
	
	  @GetMapping("/create")
	   public String form(Model model) {
		  List<Dept> deptList = hrService.getAllDepts();
		  model.addAttribute("deptList",deptList);
	      return "dept/form";         // "/WEB-INF/views/dept/form.jsp"로 내부이동 
	   }
	  
	  @PostMapping("/create") 
		public String create(DeptCreateForm deptCreateForm) {  // DeptCreateFrom객체를 파라미터로 받는다. (form에서 작성한 정보)
		  hrService.createDept(deptCreateForm); // hrService에서 createDept메서드(deptCreateForm 정보가 담겨있음)를 호출한다. 
			
			return "redirect:list"; // 목록을 보여주는 페이지로 리다이렉션
			
		}
	
}
