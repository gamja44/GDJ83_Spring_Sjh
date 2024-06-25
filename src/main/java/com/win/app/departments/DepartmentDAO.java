package com.win.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.util.DBConnection;

@Repository
public class DepartmentDAO {
	// DI=의존성주입 스프링이해줘=ioc
	@Autowired
	private DBConnection dbConnection;

	// 파일대신 데이터베이스 읽기
	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();

		// sql(쿼리문)작성

		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리서버로전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery(); // 그 결과 rs =최종 전송
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();

			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);

		}
		// 자원해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}
}
