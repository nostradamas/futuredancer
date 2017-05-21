package com.fdw.model;

public class AboutusBean {

	private String aid;
	private String aboutus;// 关于我们
	private String enlighten;// 授课模式 启蒙
	private String popularize;// 授课模式 普及
	private String specialty;// 授课模式 专家
	private String modeImg;// 授课模式图片
	private String logo;// logo

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}

	public String getModeImg() {
		return modeImg;
	}

	public void setModeImg(String modeImg) {
		this.modeImg = modeImg;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEnlighten() {
		return enlighten;
	}

	public void setEnlighten(String enlighten) {
		this.enlighten = enlighten;
	}

	public String getPopularize() {
		return popularize;
	}

	public void setPopularize(String popularize) {
		this.popularize = popularize;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "AboutusBean [aid=" + aid + ", aboutus=" + aboutus + ", enlighten=" + enlighten + ", popularize="
				+ popularize + ", specialty=" + specialty + ", modeImg=" + modeImg + ", logo=" + logo + "]";
	}

}
