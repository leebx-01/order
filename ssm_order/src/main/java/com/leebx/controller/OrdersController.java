package com.leebx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.Orders;
import com.leebx.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private IOrdersService ordersService;
	
	@RequestMapping("findAll.do")
	public String findAll(ModelMap model,int page,int size) {
		List<Orders> list=ordersService.findAll(page,size);
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(list);
		model.put("pageInfo", pageInfo);
		return "orders-list";
	}
	
	@RequestMapping("findById.do")
	public String findById(ModelMap model,String id) {
		Orders order = ordersService.findById(id);
		model.put("orders", order);
		return "orders-show";
	}
}
