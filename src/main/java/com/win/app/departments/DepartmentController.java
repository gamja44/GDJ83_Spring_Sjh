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
		// mv.setViewName("department/list");
		// return mv;

		model.addAttribute("list", ar); // 매개변수에 모델넣고 addAttribute해서 씀

	}

	@RequestMapping("detail") // 위에 리스트랑 똑같음 get생략가능
	// @RequestParam(name = "num", defaultValue = "10") int department_id
	public String getDetail(Model model, int department_id) throws Exception {

		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String path = "commons/message";

		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없다");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {

		int result = departmentService.add(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서등록 실패");
			model.addAttribute("url", "./list");
		}

		return url;
	}

	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		int result = departmentService.delete(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서삭제 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String url = "commons/message";
		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			url = "department/update";
		} else {
			model.addAttribute("result", "없는 부서입니다");
			model.addAttribute("url", "list");
		}

		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.update(departmentDTO);

		return "redirect:list";
	}

}
