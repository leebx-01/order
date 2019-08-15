package com.leebx.entity;

import java.util.Date;

public class Forcum {
	private int forcumId;
	private String forcumName;
	private String forcumPosition;
	private Date forcumDate;
	

	public Forcum() {
		super();
	}

	public int getForcumId() {
		return forcumId;
	}

	public void setForcumId(int forcumId) {
		this.forcumId = forcumId;
	}

	public String getForcumName() {
		return forcumName;
	}

	public void setForcumName(String forcumName) {
		this.forcumName = forcumName;
	}

	public String getForcumPosition() {
		return forcumPosition;
	}

	public void setForcumPosition(String forcumPosition) {
		this.forcumPosition = forcumPosition;
	}

	public Date getForcumDate() {
		return forcumDate;
	}

	public void setForcumDate(Date forcumDate) {
		this.forcumDate = forcumDate;
	}

	

}
