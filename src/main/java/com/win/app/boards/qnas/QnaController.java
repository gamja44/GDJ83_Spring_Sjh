package com.win.app.boards.qnas;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.win.app.members.MemberDTO;
import com.win.app.util.Pager;

@Controller
@RequestMapping("/board/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<QnaDTO> list = qnaService.getList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		model.addAttribute("boardType", "qna");
		return "board/list";
	}

	@GetMapping("add")
	public String addForm(Model model) throws Exception {
		model.addAttribute("mode", "add");
		model.addAttribute("boardType", "qna");
		return "board/add";
	}

	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login";
		}

		qnaDTO.setBoardWriter(member.getM_id());
		int result = qnaService.add(qnaDTO);
		return "redirect:/board/qna/list";
	}

	@GetMapping("detail")
	public String detail(int boardNum, Model model) throws Exception {
		qnaService.incrementHit(boardNum);
		QnaDTO qnaDTO = qnaService.detail(boardNum);
		model.addAttribute("qna", qnaDTO);
		model.addAttribute("mode", "detail");
		model.addAttribute("boardType", "qna");
		return "board/detail";
	}

	@GetMapping("update")
	public String updateForm(int boardNum, Model model) throws Exception {
		QnaDTO qnaDTO = qnaService.detail(boardNum);
		model.addAttribute("qna", qnaDTO);
		model.addAttribute("mode", "update");
		model.addAttribute("boardType", "qna");
		return "board/update";
	}

	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:/board/qna/detail?boardNum=" + qnaDTO.getBoardNum();
	}

	@PostMapping("delete")
	public String delete(int boardNum) throws Exception {
		int result = qnaService.delete(boardNum);
		return "redirect:/board/qna/list";
	}
}
