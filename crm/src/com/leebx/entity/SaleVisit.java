package com.leebx.entity;

import java.util.Date;

/**
 * SaleVisit entity. @author MyEclipse Persistence Tools
 */

public class SaleVisit implements java.io.Serializable {

	// Fields

	private String visitId;
	private CstCustomer cstCustomer;
	private SysUser sysUser;
	private Date visitTime;
	private Date visitEndTime;
	private String visitAddr;
	private String visitDetail;
	private Date visitNexttime;

	// Constructors

	/** default constructor */
	public SaleVisit() {
	}

	/** full constructor */
	public SaleVisit(CstCustomer cstCustomer, SysUser sysUser, Date visitTime,
			String visitAddr, String visitDetail, Date visitNexttime) {
		this.cstCustomer = cstCustomer;
		this.sysUser = sysUser;
		this.visitTime = visitTime;
		this.visitAddr = visitAddr;
		this.visitDetail = visitDetail;
		this.visitNexttime = visitNexttime;
	}

	// Property accessors

	public String getVisitId() {
		return this.visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Date getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitAddr() {
		return this.visitAddr;
	}

	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}

	public String getVisitDetail() {
		return this.visitDetail;
	}

	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}

	public Date getVisitNexttime() {
		return this.visitNexttime;
	}

	public void setVisitNexttime(Date visitNexttime) {
		this.visitNexttime = visitNexttime;
	}

	public Date getVisitEndTime() {
		return visitEndTime;
	}

	public void setVisitEndTime(Date visitEndTime) {
		this.visitEndTime = visitEndTime;
	}

}