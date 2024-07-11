package com.win.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(int startRow, int endRow) throws Exception {
		return productDAO.getList(startRow, endRow);
	}

	public ProductDTO getDetail(ProductDTO product) throws Exception {
		return productDAO.getDetail(product);
	}

	public void addProduct(ProductDTO product) throws Exception {
		productDAO.addProduct(product);
	}

	public void updateProduct(ProductDTO product) throws Exception {
		productDAO.updateProduct(product);
	}

	public void deleteProduct(ProductDTO product) throws Exception {
		productDAO.deleteProduct(product);
	}

	public int getTotalProducts() throws Exception {
		return productDAO.getTotalProducts(); // 총 제품 수를 가져오는 메서드 호출
	}
}
