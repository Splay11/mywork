package com.lab.model;
public class ClassMsg {
	private Integer id;//ID
	private String cname;//班级名
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
