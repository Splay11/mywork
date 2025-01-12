package com.lab.model;
public class Teacher {
	private Integer id;//ID
	private String tno;//工号
	private String password;//密码
	private String realName;//姓名
	private String celPhone;//联系电话
	private String jobLevel;//职称
	private Integer cid;//所属学院
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTno(){
		return tno;
	}
	public void setTno(String tno){
		this.tno = tno == null ? null : tno.trim();
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
	public String getJobLevel(){
		return jobLevel;
	}
	public void setJobLevel(String jobLevel){
		this.jobLevel = jobLevel == null ? null : jobLevel.trim();
	}
	public Integer getCid(){
		return cid;
	}
	public void setCid(Integer cid){
		this.cid = cid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
