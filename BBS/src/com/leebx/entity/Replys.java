package com.leebx.entity;

import java.util.Date;

public class Replys {
	private int topicId;
	private double replies;
	private String topicContent;
	private int borderId;
	private Date publishTime;
	private Date modifyTime;
	private int memberId;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public double getReplies() {
		return replies;
	}

	public void setReplies(double replies) {
		this.replies = replies;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public int getBorderId() {
		return borderId;
	}

	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
