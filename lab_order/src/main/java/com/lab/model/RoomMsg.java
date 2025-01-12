package com.lab.model;
public class RoomMsg {
	private Integer id;//ID
	private String roomName;//实验室名称
	private String address;//实验室地点
	private Integer manageId;//负责管理员
	private Integer maxNum;//可容纳人数
	private String remark;//备注
	private Integer roomType;//实验室类型
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getRoomName(){
		return roomName;
	}
	public void setRoomName(String roomName){
		this.roomName = roomName == null ? null : roomName.trim();
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address == null ? null : address.trim();
	}
	public Integer getManageId(){
		return manageId;
	}
	public void setManageId(Integer manageId){
		this.manageId = manageId;
	}
	public Integer getMaxNum(){
		return maxNum;
	}
	public void setMaxNum(Integer maxNum){
		this.maxNum = maxNum;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark == null ? null : remark.trim();
	}
	public Integer getRoomType(){
		return roomType;
	}
	public void setRoomType(Integer roomType){
		this.roomType = roomType;
	}
}
