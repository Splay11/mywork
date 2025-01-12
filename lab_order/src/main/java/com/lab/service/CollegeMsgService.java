package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface CollegeMsgService{
	/**
	分页查询学院数据总数
	*/
	public Map<String,Integer> getDataListCount(CollegeMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询学院数据列表
	*/
	public Map<String,Object> getDataList(CollegeMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装学院为前台展示的数据形式
	*/
	public Map<String,Object> getCollegeMsgModel(CollegeMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(CollegeMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(CollegeMsg model,LoginModel login);
}
