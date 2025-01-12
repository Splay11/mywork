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
public class OrderGatherServiceImpl implements OrderGatherService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	OrderGatherMapper orderGatherMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	/**
	*根据参数查询预约汇总列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(OrderGather queryModel,Integer pageSize,LoginModel login) {
		OrderGatherExample se = new OrderGatherExample();
		OrderGatherExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCollegeId()!=null){
			sc.andCollegeIdEqualTo(queryModel.getCollegeId());//查询学院等于指定值
		}
		if(queryModel.getCourseTime()!=null){
			sc.andCourseTimeEqualTo(queryModel.getCourseTime());//查询时段等于指定值
		}
		int count = (int)orderGatherMapper.countByExample(se);
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
	*根据参数查询预约汇总列表数据
	*/
	@Override
	public Map<String,Object> getDataList(OrderGather queryModel,Integer page,Integer pageSize,LoginModel login) {
		OrderGatherExample se = new OrderGatherExample();
		OrderGatherExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCollegeId()!=null){
			sc.andCollegeIdEqualTo(queryModel.getCollegeId());//查询学院等于指定值
		}
		if(queryModel.getCourseTime()!=null){
			sc.andCourseTimeEqualTo(queryModel.getCourseTime());//查询时段等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<OrderGather> list = orderGatherMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(OrderGather model:list){
			list2.add(getOrderGatherModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装预约汇总为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getOrderGatherModel(OrderGather model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderGather",model);
		if(model.getCollegeId()!=null){
			CollegeMsg collegeMsg = collegeMsgMapper.selectByPrimaryKey(model.getCollegeId());//学院为外接字段，需要关联学院来解释该字段
			if(collegeMsg!=null){


				map.put("collegeIdStr",collegeMsg.getCname());
			}
		}
		map.put("courseTimeStr",DataListUtils.getOrderTimeNameById(model.getCourseTime()+""));//解释时段字段
		return map;
	}
	@Override
	public void exportOrder(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login){
		List<Map<String,Object>> list2 = (List<Map<String,Object>>)data.get("list");//根据查询条件获取数据
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:list2){
			Map<String,Object> map2 = new HashMap<String,Object>();
			OrderGather orderGather = (OrderGather)map.get("orderGather");
			Object collegeId = map.get("collegeIdStr");
			if(collegeId!=null){
				map2.put("collegeId",collegeId.toString());//解释学院
			}
			Object courseTime = map.get("courseTimeStr");
			if(courseTime!=null){
				map2.put("courseTime",courseTime.toString());//解释时段
			}
			map2.put("num",orderGather.getNum());//解释数量
			list3.add(map2);
		}
		PoiExcelExport pee = new PoiExcelExport(response,"预约汇总导出报表"+sdf2.format(new Date()),"sheet1");
	String[] headers = {"学院","时段","数量"};
	String[] columns = {"collegeId","courseTime","num"};
	int[] titleSize = {20,20,20};
		try {
			pee.wirteExcel(columns, headers, titleSize, list3);//根据数据列表生成excel文件
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
