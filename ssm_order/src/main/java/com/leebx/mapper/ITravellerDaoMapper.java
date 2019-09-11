package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.leebx.entity.Traveller;

public interface ITravellerDaoMapper {

	@Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
	public List<Traveller> getOrderById(String orderId);
}
