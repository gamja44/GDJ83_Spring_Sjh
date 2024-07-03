package com.win.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.product.ProductDAO.";

	public List<ProductDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList");

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int addProduct(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addProduct", productDTO);
	}

	public int updateProduct(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateProduct", productDTO);
	}

	public int deleteProduct(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteProduct", productDTO);
	}
}
