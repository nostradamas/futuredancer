package com.fda.controller.req;

import javax.validation.constraints.Pattern;

public class EditEnvironmentDetailParam {

	private String eid;

	private String url;// 地址

	private String name;// 名称

	@Pattern(regexp = "^(1|2)$", message = "选择正确的类型")
	private String type;

	@Pattern(regexp = "^(0|1)$", message = "选择是否显示")
	private String isDel;

	private int sort;// 顺序

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}
