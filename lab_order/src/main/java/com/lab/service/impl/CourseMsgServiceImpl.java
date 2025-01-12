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
public class CourseMsgServiceImpl implements CourseMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	CourseMsgMapper courseMsgMapper;
	@Autowired
	ClassMsgMapper classMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
	/**
	新增
	*/
	@Override
	public String add(CourseMsg model,LoginModel login){
		if(model.getCname()==null||model.getCname().equals("")){
			return "课程名为必填属性";
		}
		if(model.getCaddress()==null||model.getCaddress().equals("")){
			return "上课地址为必填属性";
		}
		if(model.getClassId()==null){
			return "班级为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getCourseTime()==null){
			return "上课时间为必填属性";
		}
		model.setTeacherId(login.getId());//登录id
		String today = sdf2.format(new Date());
		courseMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(CourseMsg model,LoginModel login){
		CourseMsg preModel = courseMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getCname()==null||model.getCname().equals("")){
			return "课程名为必填属性";
		}
		if(model.getCaddress()==null||model.getCaddress().equals("")){
			return "上课地址为必填属性";
		}
		if(model.getClassId()==null){
			return "班级为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getCourseTime()==null){
			return "上课时间为必填属性";
		}
		preModel.setCname(model.getCname());
		preModel.setCaddress(model.getCaddress());
		preModel.setClassId(model.getClassId());
		preModel.setOrderDate(model.getOrderDate());
		preModel.setCourseTime(model.getCourseTime());
		String today = sdf2.format(new Date());
		courseMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询课程列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,CourseMsg queryModel,Integer pageSize,LoginModel login) {
		CourseMsgExample se = new CourseMsgExample();
		CourseMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCname()!=null&&queryModel.getCname().equals("")==false){
			sc.andCnameLike("%"+queryModel.getCname()+"%");//模糊查询
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		int count = (int)courseMsgMapper.countByExample(se);
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
	*根据参数查询课程列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,CourseMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		CourseMsgExample se = new CourseMsgExample();
		CourseMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCname()!=null&&queryModel.getCname().equals("")==false){
			sc.andCnameLike("%"+queryModel.getCname()+"%");//模糊查询
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
		List<CourseMsg> list = courseMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(CourseMsg model:list){
			list2.add(getCourseMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装课程为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getCourseMsgModel(CourseMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("courseMsg",model);
		if(model.getClassId()!=null){
			ClassMsg classMsg = classMsgMapper.selectByPrimaryKey(model.getClassId());//班级为外接字段，需要关联班级来解释该字段
			if(classMsg!=null){
				map.put("classIdStr",classMsg.getCname());
			}
		}
		if(model.getTeacherId()!=null){
			Teacher teacher = teacherMapper.selectByPrimaryKey(model.getTeacherId());//教师ID为外接字段，需要关联教师来解释该字段
			if(teacher!=null){
				map.put("teacherIdStr",teacher.getTno());
			}
		}
		map.put("courseTimeStr",DataListUtils.getOrderTimeNameById(model.getCourseTime()+""));//解释上课时间字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		courseMsgMapper.deleteByPrimaryKey(id);
	}
}
