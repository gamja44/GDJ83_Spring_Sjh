package com.win.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		List<ProductDTO> list = productService.getList();
		model.addAttribute("list", list);
		return "product/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(@RequestParam("id") int id, Model model) throws Exception {
		ProductDTO product = productService.getDetail(id);
		model.addAttribute("product", product);
		return "product/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("product", new ProductDTO());
		return "product/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductDTO product) throws Exception {
		productService.addProduct(product);
		return "redirect:/product/list";
	}
}
