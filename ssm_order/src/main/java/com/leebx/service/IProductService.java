package com.leebx.service;

import java.util.List;

import com.leebx.entity.Product;

public interface IProductService {
	public List<Product> findAll(int page,int size);
	public int save(Product product);
	public void del(String[] ids);
}
