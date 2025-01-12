package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ManageService{
	/**
	分页查询实验室管理员数据总数
	*/
	public Map<String,Integer> getDataListCount(Manage queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询实验室管理员数据列表
	*/
	public Map<String,Object> getDataList(Manage queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装实验室管理员为前台展示的数据形式
	*/
	public Map<String,Object> getManageModel(Manage model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Manage model,LoginModel login);
	/**
	修改
	*/
	public String update(Manage model,LoginModel login);
	/**
	修改
	*/
	public String update1(Manage model,LoginModel login);
}
