package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface LabOrderService{
	/**
	分页查询实验室预约数据总数
	*/
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,LabOrder queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询实验室预约数据列表
	*/
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,LabOrder queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装实验室预约为前台展示的数据形式
	*/
	public Map<String,Object> getLabOrderModel(LabOrder model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(LabOrder model,LoginModel login);
	/**
	修改
	*/
	public String update(LabOrder model,LoginModel login);
}
