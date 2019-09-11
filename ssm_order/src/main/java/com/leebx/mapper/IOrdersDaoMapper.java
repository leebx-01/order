package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.leebx.entity.Orders;

public interface IOrdersDaoMapper {
	//连表查询订单以及商品
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.leebx.mapper.IProductDaoMapper.getProductById"))
	})
	@Select("select * from orders")
	public List<Orders> findAll();
	
	//通过订单查询商品，用户，会员
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.leebx.mapper.IProductDaoMapper.getProductById")),
		@Result(column = "memberId",property = "member",one = @One(select =
		"com.leebx.mapper.IMemberDaoMapper.getMemberById")),
		@Result(column = "id",property = "travellers",many = @Many(select =
		"com.leebx.mapper.ITravellerDaoMapper.getOrderById"))
	})
	@Select("select * from orders where id=#{id}")
	public Orders findById(String id);
}
