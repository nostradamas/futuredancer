package com.fda.controller.req;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EditNewsDetailParam {
	
	private String nid;
	@NotEmpty(message="标题不能为空")
	private String title;// 新闻标题
	@NotEmpty(message="内容不能为空")
	@Length(min=0, max=100000)
	private String content;// 新闻内容

	@Length(min=0, max=300)
	private String brief;//　新闻简介
	private String img;// 新闻封面
	private String linkUrl;// 外链地址
	private String cid;// 新闻类型
	private int sort;// 顺序
	
	private String createCode;
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	
}


