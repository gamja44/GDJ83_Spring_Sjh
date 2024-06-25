package com.win.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	// IOC :제어의 역전 스프링 프레임워크가 해줌 (어노테이션 설명과실행)
	// 자바=객체생성, 메서드 호출
	// Controller Service Repository Component
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList() throws Exception {
		System.out.println("department List");
		// return "department/list" 생략가능
		departmentService.getList();
	}

}
