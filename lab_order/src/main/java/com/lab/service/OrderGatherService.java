package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface OrderGatherService{
	/**
	分页查询预约汇总数据总数
	*/
	public Map<String,Integer> getDataListCount(OrderGather queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询预约汇总数据列表
	*/
	public Map<String,Object> getDataList(OrderGather queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装预约汇总为前台展示的数据形式
	*/
	public Map<String,Object> getOrderGatherModel(OrderGather model,LoginModel login);
	/**
	导出预约汇总数据
	*/
	public void exportOrder(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login);
}
