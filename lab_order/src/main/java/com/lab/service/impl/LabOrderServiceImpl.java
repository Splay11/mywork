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
public class LabOrderServiceImpl implements LabOrderService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	LabOrderMapper labOrderMapper;
	/**
	新增
	*/
	@Override
	public String add(LabOrder model,LoginModel login){
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时间为必填属性";
		}
		if(model.getUsingIntro()==null||model.getUsingIntro().equals("")){
			return "预约用途为必填属性";
		}
		String today = sdf2.format(new Date());
		labOrderMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(LabOrder model,LoginModel login){
		LabOrder preModel = labOrderMapper.selectByPrimaryKey(model.getId());
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时间为必填属性";
		}
		if(model.getUsingIntro()==null||model.getUsingIntro().equals("")){
			return "预约用途为必填属性";
		}
		preModel.setOrderDate(model.getOrderDate());
		preModel.setOrderTime(model.getOrderTime());
		preModel.setUsingIntro(model.getUsingIntro());
		String today = sdf2.format(new Date());
		labOrderMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询实验室预约列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,LabOrder queryModel,Integer pageSize,LoginModel login) {
		LabOrderExample se = new LabOrderExample();
		LabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		int count = (int)labOrderMapper.countByExample(se);
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
	*根据参数查询实验室预约列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,LabOrder queryModel,Integer page,Integer pageSize,LoginModel login) {
		LabOrderExample se = new LabOrderExample();
		LabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<LabOrder> list = labOrderMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(LabOrder model:list){
			list2.add(getLabOrderModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装实验室预约为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getLabOrderModel(LabOrder model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("labOrder",model);
		map.put("orderTimeStr",DataListUtils.getOrderTimeNameById(model.getOrderTime()+""));//解释预约时间字段
		if(model.getRoomId()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRoomId());//实验室ID为外接字段，需要关联实验室来解释该字段
			if(roomMsg!=null){
				map.put("roomIdStr",roomMsg.getRoomName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		labOrderMapper.deleteByPrimaryKey(id);
	}
}
