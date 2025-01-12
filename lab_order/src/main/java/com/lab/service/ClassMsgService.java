package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ClassMsgService{
	/**
	分页查询班级数据总数
	*/
	public Map<String,Integer> getDataListCount(ClassMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询班级数据列表
	*/
	public Map<String,Object> getDataList(ClassMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装班级为前台展示的数据形式
	*/
	public Map<String,Object> getClassMsgModel(ClassMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(ClassMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(ClassMsg model,LoginModel login);
}
