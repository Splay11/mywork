package com.lab.model;
public class SlabOrder {
	private Integer id;//ID
	private Integer stuId;//学生ID
	private String stuNo;//学生学号
	private String stuName;//学生名
	private Integer roomId;//实验室ID
	private String appReason;//申请原因
	private Integer collegeId;//学生学院
	private String orderDate;//预约日期
	private Integer orderTime;//预约时段
	private Integer orderStatus;//预约状态
	private String createDate;//创建日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getStuId(){
		return stuId;
	}
	public void setStuId(Integer stuId){
		this.stuId = stuId;
	}
	public String getStuNo(){
		return stuNo;
	}
	public void setStuNo(String stuNo){
		this.stuNo = stuNo == null ? null : stuNo.trim();
	}
	public String getStuName(){
		return stuName;
	}
	public void setStuName(String stuName){
		this.stuName = stuName == null ? null : stuName.trim();
	}
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
	public String getAppReason(){
		return appReason;
	}
	public void setAppReason(String appReason){
		this.appReason = appReason == null ? null : appReason.trim();
	}
	public Integer getCollegeId(){
		return collegeId;
	}
	public void setCollegeId(Integer collegeId){
		this.collegeId = collegeId;
	}
	public String getOrderDate(){
		return orderDate;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate == null ? null : orderDate.trim();
	}
	public Integer getOrderTime(){
		return orderTime;
	}
	public void setOrderTime(Integer orderTime){
		this.orderTime = orderTime;
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
