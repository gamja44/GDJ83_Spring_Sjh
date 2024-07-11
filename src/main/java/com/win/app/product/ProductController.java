package com.win.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/list")
	public String getList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
			Model model) throws Exception {
		int startRow = (page - 1) * pageSize + 1;
		int endRow = page * pageSize;

		List<ProductDTO> list = productService.getList(startRow, endRow);
		int totalProducts = productService.getTotalProducts();
		int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

		model.addAttribute("list", list);
		model.addAttribute("currentPage", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalPages", totalPages);

		return "product/list";
	}

	@RequestMapping("/detail")
	public String getDetail(@RequestParam("product_id") int productId, Model model) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(productId);
		ProductDTO product = productService.getDetail(productDTO);
		model.addAttribute("product", product);
		return "product/detail";
	}

	@RequestMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("product", new ProductDTO());
		return "product/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(ProductDTO product) throws Exception {
		productService.addProduct(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(@RequestParam("product_id") int productId, Model model) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(productId);
		ProductDTO product = productService.getDetail(productDTO);
		model.addAttribute("product", product);
		return "product/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(ProductDTO product) throws Exception {
		productService.updateProduct(product);
		return "redirect:/product/list";
	}

	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("product_id") int productId) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(productId);
		productService.deleteProduct(productDTO);
		return "redirect:/product/list";
	}
}
