package com.lab.model;
public class LabOrder {
	private Integer id;//ID
	private String orderDate;//预约日期
	private Integer orderTime;//预约时间
	private String usingIntro;//预约用途
	private Integer roomId;//实验室ID
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
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
	public String getUsingIntro(){
		return usingIntro;
	}
	public void setUsingIntro(String usingIntro){
		this.usingIntro = usingIntro == null ? null : usingIntro.trim();
	}
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
}
