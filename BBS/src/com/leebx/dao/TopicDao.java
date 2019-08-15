package com.leebx.dao;

import java.util.ArrayList;
import java.util.List;

import com.leebx.entity.Member;
import com.leebx.entity.Reply;
import com.leebx.entity.Replys;
import com.leebx.entity.Topic;

public class TopicDao extends BaseDao {
	// 发帖
	public int postMessage(Topic t, int boardId, int memberId) {
		String sql = "insert into topic values(0,?,?,?,?,0,now(),now(),'a',now())";
		List params = new ArrayList();
		params.add(t.getTopicCaption());
		params.add(t.getTopicContent());
		params.add(boardId);
		params.add(memberId);
		super.setParams(params);
		return super.update(sql);
	}
	//回复帖子
	public int replyMessage(String topicContent, int boardId, int memberId,int topicId){
		String sql="insert into reply values(0,?,?,?,?,now(),now())";
		List params = new ArrayList();
		params.add(boardId);
		params.add(topicId);
		params.add(memberId);
		params.add(topicContent);
		super.setParams(params);
		return super.update(sql);
	}
	// 查询主页一条帖子
	public List searchMessage() {
		String sql = "SELECT * FROM topic t GROUP BY t.borderId";
		//
		return super.query(sql, Topic.class);
	}

	// 查询所有帖子
	public List searchAllMessage() {
		String sql = "SELECT * FROM topic t";
		return super.query(sql, Topic.class);
	}

	// 查询帖子对应名字
	public List searchName() {
		String sql = "select * from member";
		return super.query(sql, Member.class);
	}

	// 查询回复帖子数量
	public List serchReply() {
		String sql = "SELECT COUNT(r.memberId)replies,t.topicId,r.topicContent,r.publishTime,r.modifyTime,r.borderId,r.memberId FROM reply r,topic t WHERE r.topicId=t.topicId GROUP BY r.topicId";
		return super.query(sql, Replys.class);
	}
	//查询所有回复帖子
	public List serchAllReply(){
		String sql="select * from reply";
		return super.query(sql, Reply.class);
	}

}
