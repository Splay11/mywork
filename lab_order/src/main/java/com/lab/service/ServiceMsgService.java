package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ServiceMsgService{
	/**
	分页查询设备数据总数
	*/
	public Map<String,Integer> getDataListCount(ServiceMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询设备数据列表
	*/
	public Map<String,Object> getDataList(ServiceMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装设备为前台展示的数据形式
	*/
	public Map<String,Object> getServiceMsgModel(ServiceMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(ServiceMsg model,LoginModel login);
	/**
	新增
	*/
	public String add1(ServiceMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(ServiceMsg model,LoginModel login);
	/**
	修改
	*/
	public String update1(ServiceMsg model,LoginModel login);
}
