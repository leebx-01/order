package com.leebx.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.Product;
import com.leebx.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping("/findAll.do")
	public String findAll(ModelMap model,int page,int size) {
		List<Product> list = productService.findAll(page,size);
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		model.put("pageInfo", pageInfo);
		return "product-list";
	}

	@RequestMapping("/save.do")
	public String save(Product product) {
		product.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		if (productService.save(product) > 0)
			return "redirect:findAll.do?page=1&size=3";
		return "error";
	}

	@RequestMapping("/del.do")
	public String del(String[] ids) {
		System.out.println(ids);
		productService.del(ids);
		return "redirect:findAll.do?page=1&size=3";
	}
}
