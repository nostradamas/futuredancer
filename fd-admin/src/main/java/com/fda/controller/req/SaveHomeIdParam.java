package com.fda.controller.req;

public class SaveHomeIdParam {

	private String id;
	private String[] homeIds;// 关联首页
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getHomeIds() {
		return homeIds;
	}
	public void setHomeIds(String[] homeIds) {
		this.homeIds = homeIds;
	}
}
