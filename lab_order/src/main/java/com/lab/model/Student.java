package com.lab.model;
public class Student {
	private Integer id;//ID
	private String stuNo;//学号
	private String password;//密码
	private String realName;//姓名
	private String celPhone;//联系电话
	private String email;//邮箱
	private Integer sex;//性别
	private Integer stuType;//学生类型
	private Integer cid;//学院
	private String className;//班级
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getStuNo(){
		return stuNo;
	}
	public void setStuNo(String stuNo){
		this.stuNo = stuNo == null ? null : stuNo.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelPhone(){
		return celPhone;
	}
	public void setCelPhone(String celPhone){
		this.celPhone = celPhone == null ? null : celPhone.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public Integer getStuType(){
		return stuType;
	}
	public void setStuType(Integer stuType){
		this.stuType = stuType;
	}
	public Integer getCid(){
		return cid;
	}
	public void setCid(Integer cid){
		this.cid = cid;
	}
	public String getClassName(){
		return className;
	}
	public void setClassName(String className){
		this.className = className == null ? null : className.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
