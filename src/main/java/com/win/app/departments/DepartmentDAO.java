package com.win.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.util.DBConnection;

@Repository
public class DepartmentDAO {
	// DI=의존성주입 스프링이해줘=ioc
	@Autowired
	private DBConnection dbConnection;

	// 파일대신 데이터베이스 읽기
	public void getList() throws Exception {
		Connection con = dbConnection.getConnection();

		// sql(쿼리문)작성

		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리서버로전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery(); // 그 결과 rs =최종 전송

		while (rs.next()) {
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(id + " : " + name);
		}
		// 자원해제
		rs.close();
		st.close();
		con.close();

	}
}
