package com.win.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.accounts.AccountDAO;
import com.win.app.accounts.AccountDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) throws Exception {
		return memberDAO.join(memberDTO);
	}

	public Map<String, Object> login(MemberDTO memberDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
				List<AccountDTO> accounts = accountDAO.list(result);
				map.put("member", result);
				map.put("accounts", accounts);
				return map;
			}
		}
		return null;
	}

	public MemberDTO getMemberById(int m_id) throws Exception {
		return memberDAO.getMemberById(m_id);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.updateMember(memberDTO);
	}

	public int deleteMember(int m_id) throws Exception {
		return memberDAO.deleteMember(m_id);
	}
}
