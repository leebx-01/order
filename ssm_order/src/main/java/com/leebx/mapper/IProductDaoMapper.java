package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.leebx.entity.Product;

public interface IProductDaoMapper {
	// 查询所有商品
	@Select("select * from product")
	public List<Product> findAll();

	// 添加商品
	@Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	public int save(Product product);

	// 根据id查商品
	@Select("select * from product where id=#{id}")
	public Product getProductById(String id);

	@Delete("<script>" +
            "delete from product" +
            "<where>" + "id in"+
            "<foreach collection='array' item='id' index='' open='(' separator=',' close=')'>"+
            	"#{id}"
            +"</foreach>"+
            "</where>" +
            "</script>")
	public void del(String[] ids);
}
