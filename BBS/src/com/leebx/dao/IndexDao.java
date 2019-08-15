package com.leebx.dao;

import java.util.List;

import com.leebx.entity.Board;
import com.leebx.entity.Count;
import com.leebx.entity.Forcum;
import com.leebx.entity.Reply;
import com.leebx.entity.Replys;

public class IndexDao extends BaseDao {
	// 大板块查询
	public List bigSearch() {
		String sql = "SELECT * FROM forcum";
		return super.query(sql, Forcum.class);
	}
	// 小版块查询
	public List smailSearch(){
		String sql = "SELECT * FROM board";
		return super.query(sql, Board.class);
	}
	//回复帖子查询
	public List replySearch(){
		String sql = "SELECT * FROM reply";
		return super.query(sql, Reply.class);
	}
	//数量查询
	public List countSearch(){
		String sql = "SELECT COUNT(t.borderId) total,b.boardId FROM Topic t,board b WHERE t.borderId=b.boardId GROUP BY b.boardName";
		return super.query(sql, Count.class);
	}
}
