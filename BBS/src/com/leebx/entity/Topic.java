package com.leebx.entity;

import java.util.Date;

public class Topic {
	private int topicId;
	private String topicCaption;
	private String topicContent;
	private int borderId;
	private int memberId;
	private int isGood;
	private Date publishTime;
	private Date modifyTime;
	private String lastReplyUser;
	private Date lastReplyDate;

	public Topic() {
		super();
	}

	public Topic(String topicCaption, String topicContent) {
		super();
		this.topicCaption = topicCaption;
		this.topicContent = topicContent;
	}



	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicCaption() {
		return topicCaption;
	}

	public void setTopicCaption(String topicCaption) {
		this.topicCaption = topicCaption;
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getIsGood() {
		return isGood;
	}

	public void setIsGood(int isGood) {
		this.isGood = isGood;
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

	public String getLastReplyUser() {
		return lastReplyUser;
	}

	public void setLastReplyUser(String lastReplyUser) {
		this.lastReplyUser = lastReplyUser;
	}

	public Date getLastReplyDate() {
		return lastReplyDate;
	}

	public void setLastReplyDate(Date lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}

}
