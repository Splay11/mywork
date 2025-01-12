package com.lab.model;
public class CourseMsg {
	private Integer id;//ID
	private String cname;//课程名
	private String caddress;//上课地址
	private Integer classId;//班级
	private Integer teacherId;//教师ID
	private Integer courseTime;//上课时间
	private String orderDate;//预约日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getCname(){
		return cname;
	}
	public void setCname(String cname){
		this.cname = cname == null ? null : cname.trim();
	}
	public String getCaddress(){
		return caddress;
	}
	public void setCaddress(String caddress){
		this.caddress = caddress == null ? null : caddress.trim();
	}
	public Integer getClassId(){
		return classId;
	}
	public void setClassId(Integer classId){
		this.classId = classId;
	}
	public Integer getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(Integer teacherId){
		this.teacherId = teacherId;
	}
	public Integer getCourseTime(){
		return courseTime;
	}
	public void setCourseTime(Integer courseTime){
		this.courseTime = courseTime;
	}
	public String getOrderDate(){
		return orderDate;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate == null ? null : orderDate.trim();
	}
}
