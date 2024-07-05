package com.win.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);

	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
				return result;
			} else {
				return null;
			}
		}
		return result;
	}

	public MemberDTO getMemberById(int m_id) throws Exception {
		return memberDAO.getMemberById(m_id);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.updateMember(memberDTO);
	}
}
