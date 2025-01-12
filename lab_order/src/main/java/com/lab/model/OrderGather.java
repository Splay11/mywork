package com.lab.model;
public class OrderGather {
	private Integer id;//ID
	private Integer collegeId;//学院
	private Integer courseTime;//时段
	private Integer num;//数量
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getCollegeId(){
		return collegeId;
	}
	public void setCollegeId(Integer collegeId){
		this.collegeId = collegeId;
	}
	public Integer getCourseTime(){
		return courseTime;
	}
	public void setCourseTime(Integer courseTime){
		this.courseTime = courseTime;
	}
	public Integer getNum(){
		return num;
	}
	public void setNum(Integer num){
		this.num = num;
	}
}
