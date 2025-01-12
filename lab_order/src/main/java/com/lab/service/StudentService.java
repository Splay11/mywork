package com.lab.service;
import java.util.Map;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface StudentService{
	/**
	分页查询学生数据总数
	*/
	public Map<String,Integer> getDataListCount(Student queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询学生数据列表
	*/
	public Map<String,Object> getDataList(Student queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装学生为前台展示的数据形式
	*/
	public Map<String,Object> getStudentModel(Student model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Student model,LoginModel login);
	/**
	新增
	*/
	public String add1(Student model,LoginModel login);
	/**
	修改
	*/
	public String update(Student model,LoginModel login);
	/**
	修改
	*/
	public String update1(Student model,LoginModel login);
	/**
	修改
	*/
	public String update2(Student model,LoginModel login);
}
