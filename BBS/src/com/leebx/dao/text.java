package com.leebx.dao;

import java.util.List;

import com.leebx.entity.Count;

public class text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IndexDao d = new IndexDao();
		TopicDao t = new TopicDao();
//		List list = t.searchMessage();
//		List<Count> list = d.countSearch();
		
		System.out.println(t.serchReply());
	}

}
