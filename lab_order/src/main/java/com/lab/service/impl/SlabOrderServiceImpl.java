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
public class SlabOrderServiceImpl implements SlabOrderService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	SlabOrderMapper slabOrderMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	LabOrderMapper labOrderMapper;
	/**
	新增
	*/
	@Override
	public String add(SlabOrder model,LoginModel login){
		if(model.getAppReason()==null||model.getAppReason().equals("")){
			return "申请原因为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时段为必填属性";
		}
		model.setStuId(login.getId());//登录id
		model.setOrderStatus(1);//默认已申请预约,
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		Student stuIdT = studentMapper.selectByPrimaryKey(model.getStuId());//查询学生
		if(stuIdT!=null){
			model.setStuNo(stuIdT.getStuNo());//赋值stuIdT的学号
		}
		if(stuIdT!=null){
			model.setStuName(stuIdT.getRealName());//赋值stuIdT的姓名
		}
		if(stuIdT!=null){
			model.setCollegeId(stuIdT.getCid());//赋值stuIdT的学院
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
		
		
		slabOrderMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(SlabOrder model,LoginModel login){
		SlabOrder preModel = slabOrderMapper.selectByPrimaryKey(model.getId());
		if(model.getAppReason()==null||model.getAppReason().equals("")){
			return "申请原因为必填属性";
		}
		if(model.getOrderDate()==null||model.getOrderDate().equals("")){
			return "预约日期为必填属性";
		}
		if(model.getOrderTime()==null){
			return "预约时段为必填属性";
		}
		preModel.setAppReason(model.getAppReason());
		preModel.setOrderDate(model.getOrderDate());
		preModel.setOrderTime(model.getOrderTime());
		Student stuIdT = studentMapper.selectByPrimaryKey(model.getStuId());//查询学生
		if(stuIdT!=null){
			preModel.setStuNo(stuIdT.getStuNo());//赋值stuIdT的学号
		}
		if(stuIdT!=null){
			preModel.setStuName(stuIdT.getRealName());//赋值stuIdT的姓名
		}
		if(stuIdT!=null){
			preModel.setCollegeId(stuIdT.getCid());//赋值stuIdT的学院
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
		slabOrderMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询学生预约列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String orderDate1,String orderDate2,SlabOrder queryModel,Integer pageSize,LoginModel login) {
		SlabOrderExample se = new SlabOrderExample();
		SlabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getStuNo()!=null&&queryModel.getStuNo().equals("")==false){
			sc.andStuNoLike("%"+queryModel.getStuNo()+"%");//模糊查询
		}
		if(queryModel.getStuName()!=null&&queryModel.getStuName().equals("")==false){
			sc.andStuNameLike("%"+queryModel.getStuName()+"%");//模糊查询
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		if(queryModel.getOrderTime()!=null){
			sc.andOrderTimeEqualTo(queryModel.getOrderTime());//查询预约时段等于指定值
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询预约状态等于指定值
		}
		if(queryModel.getStuId()!=null){
			sc.andStuIdEqualTo(queryModel.getStuId());
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
		int count = (int)slabOrderMapper.countByExample(se);
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
	*根据参数查询学生预约列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String orderDate1,String orderDate2,SlabOrder queryModel,Integer page,Integer pageSize,LoginModel login) {
		SlabOrderExample se = new SlabOrderExample();
		SlabOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getStuNo()!=null&&queryModel.getStuNo().equals("")==false){
			sc.andStuNoLike("%"+queryModel.getStuNo()+"%");//模糊查询
		}
		if(queryModel.getStuName()!=null&&queryModel.getStuName().equals("")==false){
			sc.andStuNameLike("%"+queryModel.getStuName()+"%");//模糊查询
		}
		if(orderDate1!=null&&orderDate1.equals("")==false){
			sc.andOrderDateGreaterThanOrEqualTo(orderDate1);
		}
		if(orderDate2!=null&&orderDate2.equals("")==false){
			sc.andOrderDateLessThanOrEqualTo(orderDate2);
		}
		if(queryModel.getOrderTime()!=null){
			sc.andOrderTimeEqualTo(queryModel.getOrderTime());//查询预约时段等于指定值
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询预约状态等于指定值
		}
		if(queryModel.getStuId()!=null){
			sc.andStuIdEqualTo(queryModel.getStuId());
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
		List<SlabOrder> list = slabOrderMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(SlabOrder model:list){
			list2.add(getSlabOrderModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装学生预约为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getSlabOrderModel(SlabOrder model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("slabOrder",model);
		if(model.getStuId()!=null){
			Student student = studentMapper.selectByPrimaryKey(model.getStuId());//学生ID为外接字段，需要关联学生来解释该字段
			if(student!=null){
				map.put("stuIdStr",student.getStuNo());
			}
		}
		if(model.getRoomId()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRoomId());//实验室ID为外接字段，需要关联实验室来解释该字段
			if(roomMsg!=null){
				map.put("roomIdStr",roomMsg.getRoomName());
			}
		}
		if(model.getCollegeId()!=null){
			CollegeMsg collegeMsg = collegeMsgMapper.selectByPrimaryKey(model.getCollegeId());//学生学院为外接字段，需要关联学院来解释该字段
			if(collegeMsg!=null){
				map.put("collegeIdStr",collegeMsg.getCname());
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
		slabOrderMapper.deleteByPrimaryKey(id);
	}
}
