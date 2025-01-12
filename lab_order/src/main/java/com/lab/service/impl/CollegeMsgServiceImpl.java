package com.lab.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.dao.*;
import com.lab.model.*;
import com.lab.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.lab.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.lab.service.*;
import com.lab.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class CollegeMsgServiceImpl implements CollegeMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(CollegeMsg model,LoginModel login){
		if(model.getCname()==null||model.getCname().equals("")){
			return "学院名为必填属性";
		}
		collegeMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(CollegeMsg model,LoginModel login){
		CollegeMsg preModel = collegeMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getCname()==null||model.getCname().equals("")){
			return "学院名为必填属性";
		}
		preModel.setCname(model.getCname());
		collegeMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询学院列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(CollegeMsg queryModel,Integer pageSize,LoginModel login) {
		CollegeMsgExample se = new CollegeMsgExample();
		CollegeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCname()!=null&&queryModel.getCname().equals("")==false){
			sc.andCnameLike("%"+queryModel.getCname()+"%");//模糊查询
		}
		int count = (int)collegeMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询学院列表数据
	*/
	@Override
	public Map<String,Object> getDataList(CollegeMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		CollegeMsgExample se = new CollegeMsgExample();
		CollegeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCname()!=null&&queryModel.getCname().equals("")==false){
			sc.andCnameLike("%"+queryModel.getCname()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<CollegeMsg> list = collegeMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(CollegeMsg model:list){
			list2.add(getCollegeMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装学院为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getCollegeMsgModel(CollegeMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("collegeMsg",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		collegeMsgMapper.deleteByPrimaryKey(id);
	}
}
