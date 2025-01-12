package com.lab.model;
public class ServiceMsg {
	private Integer id;//ID
	private String serviceNae;//设备名
	private Integer serviceStatus;//设备状态
	private Integer roomId;//所属实验室
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getServiceNae(){
		return serviceNae;
	}
	public void setServiceNae(String serviceNae){
		this.serviceNae = serviceNae == null ? null : serviceNae.trim();
	}
	public Integer getServiceStatus(){
		return serviceStatus;
	}
	public void setServiceStatus(Integer serviceStatus){
		this.serviceStatus = serviceStatus;
	}
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
}
