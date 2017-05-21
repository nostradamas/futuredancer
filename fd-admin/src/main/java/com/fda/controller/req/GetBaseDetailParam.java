package com.fda.controller.req;


/**
 * 获取基本的信息
 **/
public class GetBaseDetailParam extends ReqToken {

	private String id; // userId

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
