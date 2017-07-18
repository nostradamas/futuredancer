package com.fdm.controller.req;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SubmitQuestionParam {

	@NotEmpty(message="姓名不能为空")
	private String name;// 内容名称
	@NotEmpty(message="电话不能为空")
	@Pattern(regexp = "^(1)\\d{10}$", message = "手机号格式不正确！")
	private String telephone;// 电话
	private int type;// 顺序
	@NotEmpty(message="意见不能为空")
	private String question;// 首页id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}