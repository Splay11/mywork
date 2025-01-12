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
public class TlabOrderServiceImpl implements TlabOrderService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	CourseMsgMapper courseMsgMapper;
	@Autowired
	TlabOrderMapper tlabOrderMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	LabOrderMapper labOrderMapper;
	/**
	新增
	*/
	@Override
	public String add(TlabOrder model,LoginModel login){
		if(model.getCourseId()==null){
			return "上课课程为必填属性";
		}
		if(model.getOrderReason()==null||model.getOrderReason().equals("")){
			return "预约原因为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时段为必填属性";
		}
		model.setTeacherId(login.getId());//登录id
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		model.setOrderStatus(1);//默认已申请预约,
		Teacher teacherIdT = teacherMapper.selectByPrimaryKey(model.getTeacherId());//查询教师
		if(teacherIdT!=null){
			model.setTeacherNo(teacherIdT.getTno());//赋值teacherIdT的工号
		}
		if(teacherIdT!=null){
			model.setTeacherName(teacherIdT.getRealName());//赋值teacherIdT的姓名
		}
		if(teacherIdT!=null){
			model.setCollegeId(teacherIdT.getCid());//赋值teacherIdT的所属学院
		}
		String today = sdf2.format(new Date());
		
		LabOrderExample le = new LabOrderExample();
		LabOrderExample.Criteria lc = le.createCriteria();
		lc.andOrderDateEqualTo(model.getOrderDate());
		lc.andOrderTimeEqualTo(model.getOrderTime());
		lc.andRoomIdEqualTo(model.getRoomId());
		int count = (int) labOrderMapper.countByExample(le);
		if(count>0) {
			return "该时间已被预约";
		}
		tlabOrderMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(TlabOrder model,LoginModel login){
		TlabOrder preModel = tlabOrderMapper.selectByPrimaryKey(model.getId());
		if(model.getCourseId()==null){
			return "上课课程为必填属性";
		}
		if(model.getOrderReason()==null||model.getOrderReason().equals("")){
			return "预约原因为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时段为必填属性";
		}
		preModel.setCourseId(model.getCourseId());
		preModel.setOrderReason(model.getOrderReason());
		preModel.setOrderDate(model.getOrderDate());
		preModel.setOrderTime(model.getOrderTime());
		Teacher teacherIdT = teacherMapper.selectByPrimaryKey(model.getTeacherId());//查询教师
		if(teacherIdT!=null){
			preModel.setTeacherNo(teacherIdT.getTno());//赋值teacherIdT的工号
		}
		if(teacherIdT!=null){
			preModel.setTeacherName(teacherIdT.getRealName());//赋值teacherIdT的姓名
		}
		if(teacherIdT!=null){
			preModel.setCollegeId(teacherIdT.getCid());//赋值teacherIdT的所属学院
		}
		
		LabOrderExample le = new LabOrderExample();
		LabOrderExample.Criteria lc = le.createCriteria();
		lc.andOrderDateEqualTo(model.getOrderDate());
		lc.andOrderTimeEqualTo(model.getOrderTime());
		lc.andRoomIdEqualTo(model.getRoomId());
		int count = (int) labOrderMapper.countByExample(le);
		if(count>0) {
			return "该时间已被预约";
		}
		String today = sdf2.format(new Date());
		tlabOrderMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询教师实验预约列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,TlabOrder queryModel,Integer pageSize,LoginModel login) {
		TlabOrderExample se = new TlabOrderExample();
		TlabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getTeacherNo()!=null&&queryModel.getTeacherNo().equals("")==false){
			sc.andTeacherNoLike("%"+queryModel.getTeacherNo()+"%");//模糊查询
		}
		if(queryModel.getTeacherName()!=null&&queryModel.getTeacherName().equals("")==false){
			sc.andTeacherNameLike("%"+queryModel.getTeacherName()+"%");//模糊查询
		}
		if(queryModel.getCollegeId()!=null){
			sc.andCollegeIdEqualTo(queryModel.getCollegeId());//查询学院等于指定值
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询预约状态等于指定值
		}
		if(queryModel.getTeacherId()!=null){
			sc.andTeacherIdEqualTo(queryModel.getTeacherId());
		}
		
		if(login.getLoginType()==2) {
			RoomMsgExample re = new RoomMsgExample();
			RoomMsgExample.Criteria rc =re.createCriteria();
			rc.andManageIdEqualTo(login.getId());
			List<RoomMsg> rl = roomMsgMapper.selectByExample(re);
			List<Integer> rids = new ArrayList<Integer>();
			for( RoomMsg r:rl) {
				rids.add(r.getId());
			}
			if(rids.size()>0) {
				sc.andIdIn(rids);
			}else {
				sc.andIdEqualTo(0);
			}
			
		}
		int count = (int)tlabOrderMapper.countByExample(se);
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
	*根据参数查询教师实验预约列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,TlabOrder queryModel,Integer page,Integer pageSize,LoginModel login) {
		TlabOrderExample se = new TlabOrderExample();
		TlabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getTeacherNo()!=null&&queryModel.getTeacherNo().equals("")==false){
			sc.andTeacherNoLike("%"+queryModel.getTeacherNo()+"%");//模糊查询
		}
		if(queryModel.getTeacherName()!=null&&queryModel.getTeacherName().equals("")==false){
			sc.andTeacherNameLike("%"+queryModel.getTeacherName()+"%");//模糊查询
		}
		if(queryModel.getCollegeId()!=null){
			sc.andCollegeIdEqualTo(queryModel.getCollegeId());//查询学院等于指定值
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询预约状态等于指定值
		}
		if(queryModel.getTeacherId()!=null){
			sc.andTeacherIdEqualTo(queryModel.getTeacherId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		
		if(login.getLoginType()==2) {
			RoomMsgExample re = new RoomMsgExample();
			RoomMsgExample.Criteria rc =re.createCriteria();
			rc.andManageIdEqualTo(login.getId());
			List<RoomMsg> rl = roomMsgMapper.selectByExample(re);
			List<Integer> rids = new ArrayList<Integer>();
			for( RoomMsg r:rl) {
				rids.add(r.getId());
			}
			if(rids.size()>0) {
				sc.andIdIn(rids);
			}else {
				sc.andIdEqualTo(0);
			}
			
		}
		List<TlabOrder> list = tlabOrderMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(TlabOrder model:list){
			list2.add(getTlabOrderModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装教师实验预约为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getTlabOrderModel(TlabOrder model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tlabOrder",model);
		if(model.getTeacherId()!=null){
			Teacher teacher = teacherMapper.selectByPrimaryKey(model.getTeacherId());//教师ID为外接字段，需要关联教师来解释该字段
			if(teacher!=null){
				map.put("teacherIdStr",teacher.getTno());
			}
		}
		if(model.getCollegeId()!=null){
			CollegeMsg collegeMsg = collegeMsgMapper.selectByPrimaryKey(model.getCollegeId());//学院为外接字段，需要关联学院来解释该字段
			if(collegeMsg!=null){
				map.put("collegeIdStr",collegeMsg.getCname());
			}
		}
		if(model.getRoomId()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRoomId());//实验室为外接字段，需要关联实验室来解释该字段
			if(roomMsg!=null){
				map.put("roomIdStr",roomMsg.getRoomName());
			}
		}
		if(model.getCourseId()!=null){
			CourseMsg courseMsg = courseMsgMapper.selectByPrimaryKey(model.getCourseId());//上课课程为外接字段，需要关联课程来解释该字段
			if(courseMsg!=null){
				map.put("courseIdStr",courseMsg.getCname());
			}
		}
		map.put("orderTimeStr",DataListUtils.getOrderTimeNameById(model.getOrderTime()+""));//解释预约时段字段
		map.put("orderStatusStr",DataListUtils.getOrderStatusNameById(model.getOrderStatus()+""));//解释预约状态字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		tlabOrderMapper.deleteByPrimaryKey(id);
	}
}
