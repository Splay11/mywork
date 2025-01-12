package com.lab.model;
public class TlabOrder {
	private Integer id;//ID
	private Integer teacherId;//教师ID
	private String teacherNo;//教师工号
	private String teacherName;//教师名
	private Integer roomId;//实验室
	private String orderReason;//预约原因
	private String orderDate;//预约日期
	private Integer orderTime;//预约时段
	private String createTime;//创建时间
	private Integer orderStatus;//预约状态
	private Integer courseId;//上课课程
	private Integer collegeId;//学院
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(Integer teacherId){
		this.teacherId = teacherId;
	}
	public String getTeacherNo(){
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo){
		this.teacherNo = teacherNo == null ? null : teacherNo.trim();
	}
	public String getTeacherName(){
		return teacherName;
	}
	public void setTeacherName(String teacherName){
		this.teacherName = teacherName == null ? null : teacherName.trim();
	}
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
	public String getOrderReason(){
		return orderReason;
	}
	public void setOrderReason(String orderReason){
		this.orderReason = orderReason == null ? null : orderReason.trim();
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
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public Integer getCourseId(){
		return courseId;
	}
	public void setCourseId(Integer courseId){
		this.courseId = courseId;
	}
	public Integer getCollegeId(){
		return collegeId;
	}
	public void setCollegeId(Integer collegeId){
		this.collegeId = collegeId;
	}
}
