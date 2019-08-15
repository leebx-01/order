package com.leebx.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CstCustomer entity. @author MyEclipse Persistence Tools
 */

public class CstCustomer implements java.io.Serializable {

	// Fields

	private Long custId;
	private BaseDict baseDict;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custPhone;
	private String custMobile;
	private Set saleVisits = new HashSet(0);
	private Set cstLinkmans = new HashSet(0);

	// Constructors

	/** default constructor */
	public CstCustomer() {
	}

	/** minimal constructor */
	public CstCustomer(String custName) {
		this.custName = custName;
	}

	/** full constructor */
	public CstCustomer(BaseDict baseDict, String custName, String custSource,
			String custIndustry, String custPhone, String custMobile,
			Set saleVisits, Set cstLinkmans) {
		this.baseDict = baseDict;
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.saleVisits = saleVisits;
		this.cstLinkmans = cstLinkmans;
	}

	// Property accessors

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public BaseDict getBaseDict() {
		return this.baseDict;
	}

	public void setBaseDict(BaseDict baseDict) {
		this.baseDict = baseDict;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return this.custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return this.custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustPhone() {
		return this.custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return this.custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Set getSaleVisits() {
		return this.saleVisits;
	}

	public void setSaleVisits(Set saleVisits) {
		this.saleVisits = saleVisits;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}


}