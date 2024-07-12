package com.win.app.notice;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.app.members.MemberDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Long page, String kind, String search, Model model) throws Exception {
		Map<String, Object> map = noticeService.getList(page, kind, search);
		model.addAttribute("map", map);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "notice/form";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		// 로그인한 사용자 정보 가져오기
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login"; // 로그인 페이지로 리다이렉트
		}

		noticeDTO.setBoardWriter(member.getM_id());

		int result = noticeService.add(noticeDTO);

		return "redirect:/notice/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int boardNum, Model model) throws Exception {
		NoticeDTO noticeDTO = noticeService.detail(boardNum);
		model.addAttribute("dto", noticeDTO);
		return "notice/detail";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(int boardNum, Model model) throws Exception {
		NoticeDTO noticeDTO = noticeService.detail(boardNum);
		model.addAttribute("dto", noticeDTO);
		return "notice/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:/notice/detail?boardNum=" + noticeDTO.getBoardNum();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(int boardNum) throws Exception {
		int result = noticeService.delete(boardNum);
		return "redirect:/notice/list";
	}
}
