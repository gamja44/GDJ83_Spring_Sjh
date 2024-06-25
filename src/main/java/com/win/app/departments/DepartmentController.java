package com.win.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void getList(Model model) throws Exception {
		System.out.println("department List");
		// return "department/list" 생략가능
		List<DepartmentDTO> ar = departmentService.getList();

		// Model +view =jsp까지 살아감 <직접 모델만들어서 사용>
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list",ar);

		// return mv;

		model.addAttribute("list", ar); // 매개변수에 모델넣고 addAttribute해서 씀

	}

}
