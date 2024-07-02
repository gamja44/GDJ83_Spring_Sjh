package com.win.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();

		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
			productDTO.setProduct_type(rs.getString("PRODUCT_TYPE"));
			productDTO.setProduct_rate(rs.getDouble("PRODUCT_RATE"));
			productDTO.setProduct_detail(rs.getString("PRODUCT_DETAIL"));
			ar.add(productDTO);
		}
		rs.close();
		st.close();
		con.close();

		return ar;
	}
}
