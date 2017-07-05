package com.fdm.controller.req;

import org.hibernate.validator.constraints.NotEmpty;

public class EditFooterDetailParam {
	private String fid;

	private String title;

	@NotEmpty(message = "公司名称不能为空")
	private String company;

	@NotEmpty(message = "手机号不能为空")
	private String telephone;

	private String phoneNum;
	@NotEmpty(message = "地址不能为空")
	private String address;
	private String record;
	private String childCode;
	private String childCodeTitle;
	private String adultCode;
	private String adultCodeTitle;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getChildCode() {
		return childCode;
	}

	public void setChildCode(String childCode) {
		this.childCode = childCode;
	}

	public String getChildCodeTitle() {
		return childCodeTitle;
	}

	public void setChildCodeTitle(String childCodeTitle) {
		this.childCodeTitle = childCodeTitle;
	}

	public String getAdultCode() {
		return adultCode;
	}

	public void setAdultCode(String adultCode) {
		this.adultCode = adultCode;
	}

	public String getAdultCodeTitle() {
		return adultCodeTitle;
	}

	public void setAdultCodeTitle(String adultCodeTitle) {
		this.adultCodeTitle = adultCodeTitle;
	}

}
