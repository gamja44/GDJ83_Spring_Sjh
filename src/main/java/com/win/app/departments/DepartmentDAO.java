package com.win.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// detail

	public DepartmentDTO getDetail(int num) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		PreparedStatement st = con.prepareStatement(sql);

		// ?세팅
		st.setInt(1, num); // sql 인젝션 방지하기위함

		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = null;
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt(1));
			departmentDTO.setLocation_id(rs.getInt(4));
			departmentDTO.setDepartment_name(rs.getString(2));
			departmentDTO.setManager_id(rs.getLong(3));
		}

		rs.close();
		st.close();
		con.close();

		return departmentDTO;

	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		// 1.db연결
		Connection con = dbConnection.getConnection();

		// 2.sql생성
		String sql = "INSERT INTO DEPARTMENTS" + " (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " values (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";

		// 3.미리전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4.세팅
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		// 5.최종전송및 결과전송
		int result = st.executeUpdate(); //

		// 6.자원 해제
		st.close();
		con.close();

		return result;

	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID =?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		int result = 0;
		Connection con = dbConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=?" + " WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	// 부서별 정보조회
	public List<Map<String, Object>> getInfo() throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT DEPARTMENT_ID, SUM(SALARY), AVG(SALARY) a" + " FROM EMPLOYEES" + " GROUP BY DEPARTMENT_ID";
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();

		while (rs.next()) {

			Map<String, Object> map = new HashMap<String, Object>();
			int id = rs.getInt("DEPARTMENT_ID");
			int sum = rs.getInt(2);
			Double avg = rs.getDouble("a");

			map.put("id", id);
			map.put("sum", sum);
			map.put("avg", avg);

			ar.add(map);

		}

		rs.close();
		st.close();
		con.close();
		return ar;
	}

}
