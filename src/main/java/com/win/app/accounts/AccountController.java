package com.win.app.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.win.app.members.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String createForm(HttpSession session, Model model, @RequestParam("product_id") Integer productId) {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login";
		}
		model.addAttribute("member", member);
		model.addAttribute("product_id", productId);
		return "accounts/create";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String create(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login";
		}
		accountDTO.setM_id(member.getM_id());
		accountDTO.setJoin_date(new java.sql.Date(System.currentTimeMillis())); // 가입 날짜 설정
		accountDTO.setAccount_number(generateAccountNumber()); // 계좌 번호 자동 생성

		int result = accountService.createAccount(accountDTO);
		if (result > 0) {
			model.addAttribute("account", accountDTO);
			return "accounts/detail";
		} else {
			return "accounts/create";
		}
	}

	private String generateAccountNumber() {
		// 계좌 번호 생성 로직
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return "ACC" + sdf.format(new Date());
	}
}
