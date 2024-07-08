package com.win.app.members;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.win.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("정효");

		MemberDTO result = memberDAO.login(memberDTO);

		assertNotNull(result); // MemberDTO 객체가 null이 아닌지 확인
		assertNotNull(result.getDtos()); // 계좌 정보 리스트가 null이 아닌지 확인
		assertTrue(result.getDtos().size() >= 0); // 계좌 정보 리스트가 비어있거나, 계좌 정보가 있는지 확인
	}
}
