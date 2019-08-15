package com.leebx.entity;

import java.util.Date;

public class Member {
	private int memberId;
	private String memberName;
	private String memberPwd;
	private String memberIcon;
	private String memberGender;
	private int isAdmin;
	private int isPass;
	private int isPower;
	private Date regDate;

	public Member() {
		super();
	}

	public Member(String memberName, String memberPwd, String memberIcon,
			String memberGender) {
		super();
		this.memberName = memberName;
		this.memberPwd = memberPwd;
		this.memberIcon = memberIcon;
		this.memberGender = memberGender;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberIcon() {
		return memberIcon;
	}

	public void setMemberIcon(String memberIcon) {
		this.memberIcon = memberIcon;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public int getIsPower() {
		return isPower;
	}

	public void setIsPower(int isPower) {
		this.isPower = isPower;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
