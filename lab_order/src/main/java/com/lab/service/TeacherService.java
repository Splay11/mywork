package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface TeacherService{
	/**
	分页查询教师数据总数
	*/
	public Map<String,Integer> getDataListCount(Teacher queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询教师数据列表
	*/
	public Map<String,Object> getDataList(Teacher queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装教师为前台展示的数据形式
	*/
	public Map<String,Object> getTeacherModel(Teacher model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Teacher model,LoginModel login);
	/**
	修改
	*/
	public String update(Teacher model,LoginModel login);
	/**
	修改
	*/
	public String update1(Teacher model,LoginModel login);
}
