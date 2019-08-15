package com.leebx.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseDict entity. @author MyEclipse Persistence Tools
 */

public class BaseDict implements java.io.Serializable {

	// Fields

	private String dictId;
	private String dictTypeCode;
	private String dictTypeName;
	private String dictItemName;
	private String dictItemCode;
	private Integer dictSort;
	private String dictEnable;
	private String dictMemo;
	private Set cstCustomersForCustLevel = new HashSet(0);
	private Set cstCustomersForCustIndustry = new HashSet(0);
	private Set cstCustomersForCustSource = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseDict() {
	}

	/** minimal constructor */
	public BaseDict(String dictTypeCode, String dictTypeName,
			String dictItemName, String dictEnable) {
		this.dictTypeCode = dictTypeCode;
		this.dictTypeName = dictTypeName;
		this.dictItemName = dictItemName;
		this.dictEnable = dictEnable;
	}

	/** full constructor */
	public BaseDict(String dictTypeCode, String dictTypeName,
			String dictItemName, String dictItemCode, Integer dictSort,
			String dictEnable, String dictMemo, Set cstCustomersForCustLevel,
			Set cstCustomersForCustIndustry, Set cstCustomersForCustSource) {
		this.dictTypeCode = dictTypeCode;
		this.dictTypeName = dictTypeName;
		this.dictItemName = dictItemName;
		this.dictItemCode = dictItemCode;
		this.dictSort = dictSort;
		this.dictEnable = dictEnable;
		this.dictMemo = dictMemo;
		this.cstCustomersForCustLevel = cstCustomersForCustLevel;
		this.cstCustomersForCustIndustry = cstCustomersForCustIndustry;
		this.cstCustomersForCustSource = cstCustomersForCustSource;
	}

	// Property accessors

	public String getDictId() {
		return this.dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictTypeCode() {
		return this.dictTypeCode;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public String getDictTypeName() {
		return this.dictTypeName;
	}

	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}

	public String getDictItemName() {
		return this.dictItemName;
	}

	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	public String getDictItemCode() {
		return this.dictItemCode;
	}

	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}

	public Integer getDictSort() {
		return this.dictSort;
	}

	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}

	public String getDictEnable() {
		return this.dictEnable;
	}

	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}

	public String getDictMemo() {
		return this.dictMemo;
	}

	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}

	public Set getCstCustomersForCustLevel() {
		return this.cstCustomersForCustLevel;
	}

	public void setCstCustomersForCustLevel(Set cstCustomersForCustLevel) {
		this.cstCustomersForCustLevel = cstCustomersForCustLevel;
	}

	public Set getCstCustomersForCustIndustry() {
		return this.cstCustomersForCustIndustry;
	}

	public void setCstCustomersForCustIndustry(Set cstCustomersForCustIndustry) {
		this.cstCustomersForCustIndustry = cstCustomersForCustIndustry;
	}

	public Set getCstCustomersForCustSource() {
		return this.cstCustomersForCustSource;
	}

	public void setCstCustomersForCustSource(Set cstCustomersForCustSource) {
		this.cstCustomersForCustSource = cstCustomersForCustSource;
	}

}