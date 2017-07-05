package com.fdm.controller.req;

public class EditPageContentDetailParam {

	private String pid;
	private String title;
	private String subTitle;
	private String content;
	private String pic;
	private String background;
	private int sort;
	private String contentId;
	private String targetId;
	private int type;

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

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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

	@Override
	public String toString() {
		return "EditPageContentDetailParam [pid=" + pid + ", title=" + title + ", subTitle=" + subTitle + ", content="
				+ content + ", pic=" + pic + ", background=" + background + ", sort=" + sort + ", contentId="
				+ contentId + ", targetId=" + targetId + ", type=" + type + "]";
	}

}
