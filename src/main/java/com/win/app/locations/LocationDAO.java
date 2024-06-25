package com.win.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.util.DBConnection;

@Repository
public class LocationDAO {
	@Autowired
	private DBConnection dbConnection;

	/**
	 * getList 메서드는 Location 테이블의 모든 데이터를 조회하여 리스트로 반환합니다.
	 * 
	 * @return List<LocationDTO> - 조회된 Location 데이터 리스트
	 * @throws Exception - 데이터베이스 연결 또는 쿼리 실행 중 발생하는 예외
	 */
	public List getList() throws Exception {
		Connection con = dbConnection.getConnection(); // 데이터베이스 연결 객체 생성
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC"; // SQL 쿼리 작성
		PreparedStatement st = con.prepareStatement(sql); // SQL 쿼리를 서버로 전송할 준비
		ResultSet rs = st.executeQuery(); // SQL 쿼리 실행 및 결과 저장
		List<LocationDTO> ar = new ArrayList<LocationDTO>();// 결과를 저장할 리스트 생성

		while (rs.next()) {// 결과 집합에서 데이터를 추출
			LocationDTO locationDTO = new LocationDTO();// LocationDTO 객체 생성
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID")); // location_id 설정
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));// street_address 설정
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO); // 리스트에 locationDTO 추가

		}
		rs.close();
		st.close();
		con.close();
		return ar; // 조회된 리스트 반환
	}

}
