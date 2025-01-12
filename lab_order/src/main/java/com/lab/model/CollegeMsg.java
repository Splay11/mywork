package com.lab.model;
public class CollegeMsg {
	private Integer id;//ID
	private String cname;//学院名
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
}
