package com.fdm.model;

public class PageContentBean {

	private String pid;
	private String title;
	private String subTitle;
	private String content;// 内容
	private String pic;// 图片
	private String background;// 背景
	private String bgCss;// 背景样式
	private String contentId;// 关联内容页面id
	private String targetId;// 关联所属页面
	private int type;// 所属页面类型 1 tab 2 menu
	
	private int sort;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBgCss() {
		return bgCss;
	}

	public void setBgCss(String bgCss) {
		this.bgCss = bgCss;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "PageContentBean [pid=" + pid + ", title=" + title + ", subTitle=" + subTitle + ", content=" + content
				+ ", pic=" + pic + ", background=" + background + ", bgCss=" + bgCss + ", contentId=" + contentId
				+ ", targetId=" + targetId + ", type=" + type + ", sort=" + sort + "]";
	}


}
