package com.win.app.products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.win.app.DefaultTest;
import com.win.app.product.ProductDAO;
import com.win.app.product.ProductDTO;

public class ProductDAOTest extends DefaultTest {
	@Autowired
	private ProductDAO productDAO;

	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(1);
		productDTO = productDAO.getDetail(productDTO);

		assertNotNull(productDTO); // 단정문
	}

	@Test
	public void addProductTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_type("Test Type");
		productDTO.setProduct_rate(1.5);
		productDTO.setProduct_detail("This is a test product.");

		int result = productDAO.addProduct(productDTO);

		assertEquals(1, result); // 단정문
	}

}
