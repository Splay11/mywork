package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface TlabOrderService{
	/**
	分页查询教师实验预约数据总数
	*/
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,TlabOrder queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询教师实验预约数据列表
	*/
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,TlabOrder queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装教师实验预约为前台展示的数据形式
	*/
	public Map<String,Object> getTlabOrderModel(TlabOrder model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(TlabOrder model,LoginModel login);
	/**
	修改
	*/
	public String update(TlabOrder model,LoginModel login);
}
