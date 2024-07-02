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

	public ProductDTO getDetail(int id) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		ProductDTO productDTO = null;

		if (rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
			productDTO.setProduct_type(rs.getString("PRODUCT_TYPE"));
			productDTO.setProduct_rate(rs.getDouble("PRODUCT_RATE"));
			productDTO.setProduct_detail(rs.getString("PRODUCT_DETAIL"));
		}
		rs.close();
		st.close();
		con.close();

		return productDTO;
	}

	public void addProduct(ProductDTO product) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_TYPE, PRODUCT_RATE, PRODUCT_DETAIL) VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, product.getProduct_type());
		st.setDouble(2, product.getProduct_rate());
		st.setString(3, product.getProduct_detail());
		st.executeUpdate();
		st.close();
		con.close();
	}

}
