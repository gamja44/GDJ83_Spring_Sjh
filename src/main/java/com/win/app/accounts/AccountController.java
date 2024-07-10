package com.win.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.win.app.members.MemberDTO;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login";
		}
		accountDTO.setM_id(member.getM_id());
		int result = accountService.add(accountDTO);
		return "redirect:/";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("account_number") String accountNumber, Model model) throws Exception {
		AccountDTO accountDTO = accountService.detail(accountNumber);
		model.addAttribute("account", accountDTO);
		return "account/detail";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String transferForm(@RequestParam("fromAccount") String fromAccount, Model model) {
		model.addAttribute("fromAccount", fromAccount);
		return "account/transfer";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String transfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount,
			@RequestParam("amount") Double amount, Model model) throws Exception {
		boolean success = accountService.transfer(fromAccount, toAccount, amount);
		if (success) {
			return "redirect:/members/mypage";
		} else {
			model.addAttribute("error", "Transfer failed due to insufficient funds or invalid account.");
			return "account/transfer";
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getHistoryList(@RequestParam("accountNumber") String accountNumber,
			@RequestParam(value = "order", required = false, defaultValue = "0") Integer order, Model model)
			throws Exception {
		ListOption listOption = new ListOption();
		listOption.setAccountNumber(accountNumber);
		listOption.setOrder(order);
		model.addAttribute("historyList", accountService.getHistoryList(listOption));
		return "account/list";
	}
}