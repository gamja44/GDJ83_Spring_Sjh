package com.win.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.app.boards.BoardDTO;
import com.win.app.util.Pager;

@Controller
@RequestMapping("/board/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = noticeService.getList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		model.addAttribute("boardType", "notice");
		return "board/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO.getBoardNum());
		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("boardType", "notice");
		return "board/detail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		return "redirect:/board/notice/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(int boardNum, Model model) throws Exception {
		NoticeDTO noticeDTO = noticeService.detail(boardNum);
		model.addAttribute("boardDTO", noticeDTO);
		model.addAttribute("mode", "update");
		model.addAttribute("boardType", "notice");
		return "board/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:/board/notice/detail?boardNum=" + noticeDTO.getBoardNum();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(int boardNum) throws Exception {
		int result = noticeService.delete(boardNum);
		return "redirect:/board/notice/list";
	}
}
