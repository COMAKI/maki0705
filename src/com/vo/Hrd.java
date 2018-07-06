package com.vo;


import java.util.Date;

public class Hrd {
	private String title;
	private String titleIcon;
	private String imgGubun;
	private String subTitle;
	private String address;
	private String telNo;
	private String contents;
	private String superViser;
	private String trainTarget;
	private String yardMan;
	private String realMan;
	private String courseMan;
	private String regCourseMan;
	private String traEndDate;
	private String traStartDate;
	private String grade;
	private String ncsCd;
	private String instCd;
	private String trprId;
	private String trprDegr;
	
	public Hrd() {
		super();
	}
	
	public Hrd(String title, String titleIcon, String imgGubun, String subTitle, String address, String telNo,
			String contents, String superViser, String trainTarget, String yardMan, String realMan, String courseMan,
			String regCourseMan, String traEndDate, String traStartDate, String grade, String ncsCd, String instCd,
			String trprId, String trprDegr) {
		super();
		this.title = title;
		this.titleIcon = titleIcon;
		this.imgGubun = imgGubun;
		this.subTitle = subTitle;
		this.address = address;
		this.telNo = telNo;
		this.contents = contents;
		this.superViser = superViser;
		this.trainTarget = trainTarget;
		this.yardMan = yardMan;
		this.realMan = realMan;
		this.courseMan = courseMan;
		this.regCourseMan = regCourseMan;
		this.traEndDate = traEndDate;
		this.traStartDate = traStartDate;
		this.grade = grade;
		this.ncsCd = ncsCd;
		this.instCd = instCd;
		this.trprId = trprId;
		this.trprDegr = trprDegr;
	}

	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTitleIcon() {
		return titleIcon;
	}



	public void setTitleIcon(String titleIcon) {
		this.titleIcon = titleIcon;
	}



	public String getImgGubun() {
		return imgGubun;
	}



	public void setImgGubun(String imgGubun) {
		this.imgGubun = imgGubun;
	}



	public String getSubTitle() {
		return subTitle;
	}



	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTelNo() {
		return telNo;
	}



	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getSuperViser() {
		return superViser;
	}



	public void setSuperViser(String superViser) {
		this.superViser = superViser;
	}



	public String getTrainTarget() {
		return trainTarget;
	}



	public void setTrainTarget(String trainTarget) {
		this.trainTarget = trainTarget;
	}



	public String getYardMan() {
		return yardMan;
	}



	public void setYardMan(String yardMan) {
		this.yardMan = yardMan;
	}



	public String getRealMan() {
		return realMan;
	}



	public void setRealMan(String realMan) {
		this.realMan = realMan;
	}



	public String getCourseMan() {
		return courseMan;
	}



	public void setCourseMan(String courseMan) {
		this.courseMan = courseMan;
	}



	public String getRegCourseMan() {
		return regCourseMan;
	}



	public void setRegCourseMan(String regCourseMan) {
		this.regCourseMan = regCourseMan;
	}



	public String getTraEndDate() {
		return traEndDate;
	}



	public void setTraEndDate(String traEndDate) {
		this.traEndDate = traEndDate;
	}



	public String getTraStartDate() {
		return traStartDate;
	}



	public void setTraStartDate(String traStartDate) {
		this.traStartDate = traStartDate;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getNcsCd() {
		return ncsCd;
	}



	public void setNcsCd(String ncsCd) {
		this.ncsCd = ncsCd;
	}



	public String getInstCd() {
		return instCd;
	}



	public void setInstCd(String instCd) {
		this.instCd = instCd;
	}



	public String getTrprId() {
		return trprId;
	}



	public void setTrprId(String trprId) {
		this.trprId = trprId;
	}



	public String getTrprDegr() {
		return trprDegr;
	}



	public void setTrprDegr(String trprDegr) {
		this.trprDegr = trprDegr;
	}



	@Override
	public String toString() {
		return "Product [title=" + title + ", titleIcon=" + titleIcon + ", imgGubun=" + imgGubun + ", subTitle="
				+ subTitle + ", address=" + address + ", telNo=" + telNo + ", contents=" + contents + ", superViser="
				+ superViser + ", trainTarget=" + trainTarget + ", yardMan=" + yardMan + ", realMan=" + realMan
				+ ", courseMan=" + courseMan + ", regCourseMan=" + regCourseMan + ", traEndDate=" + traEndDate
				+ ", traStartDate=" + traStartDate + ", grade=" + grade + ", ncsCd=" + ncsCd + ", instCd=" + instCd
				+ ", trprId=" + trprId + ", trprDegr=" + trprDegr + "]";
	}

	
	
	
}



