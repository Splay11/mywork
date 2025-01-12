package com.lab.controller.manage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.lab.dao.*;
import com.lab.model.*;
import com.lab.service.impl.*;
import com.lab.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.lab.controller.LoginModel;
import com.lab.service.*;
@Controller
@RequestMapping("/manage/tlab_order")
public class MTlabOrderController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	TlabOrderService tlabOrderService;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	CourseMsgMapper courseMsgMapper;
	@Autowired
	TlabOrderMapper tlabOrderMapper;
	@Autowired
	ManageMapper manageMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	LabOrderMapper labOrderMapper;
	public void getList(Map<String,Object> rs ,LoginModel login){
		CollegeMsgExample collegeMsgE = new CollegeMsgExample();
		List<CollegeMsg> collegeMsgList=collegeMsgMapper.selectByExample(collegeMsgE);
		List<Map<String,Object>>  collegeMsgList2 = new ArrayList<Map<String,Object>>();
		for(CollegeMsg m:collegeMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getCname());
			collegeMsgList2.add(map);
		}
		rs.put("collegeMsgList",collegeMsgList2);
		rs.put("orderStatusList",DataListUtils.getOrderStatusList());//返回order_status列表
	}
	/**
	* 根据查询条件分页查询教师实验预约数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(TlabOrder model,Integer page,String orderDate1,String orderDate2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return tlabOrderService.getDataListCount(orderDate1,orderDate2,model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		Manage manage = manageMapper.selectByPrimaryKey(login.getId());
		rs.put("user",manage);
		getList( rs,login);//获取数据列表并返回给前台
		return rs;
	}
	/**
	* 根据查询条件分页查询教师实验预约数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(TlabOrder model,Integer page,String orderDate1,String orderDate2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return tlabOrderService.getDataList(orderDate1,orderDate2,model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除教师实验预约接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		tlabOrderService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "jsyy")
	@ResponseBody
	public Object jsyy(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		TlabOrder model = tlabOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该教师实验预约已不存在");
			return rs;
		}
		
		LabOrderExample le = new LabOrderExample();
		LabOrderExample.Criteria lc = le.createCriteria();
		lc.andOrderDateEqualTo(model.getOrderDate());
		lc.andOrderTimeEqualTo(model.getOrderTime());
		lc.andRoomIdEqualTo(model.getRoomId());
		int count = (int) labOrderMapper.countByExample(le);
		if(count>0) {
			rs.put("code", 0);
			rs.put("msg","该时间已被预约，不能同意");
			return rs;
		}
		LabOrder order = new LabOrder();
		order.setOrderDate(model.getOrderDate());
		order.setOrderTime(model.getOrderTime());
		order.setRoomId(model.getRoomId());
		order.setUsingIntro(model.getOrderReason());
		labOrderMapper.insertSelective(order);
		model.setOrderStatus(2);
		tlabOrderMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","接受预约成功");
		return rs;
	}
	@RequestMapping(value = "jjyy")
	@ResponseBody
	public Object jjyy(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		TlabOrder model = tlabOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该教师实验预约已不存在");
			return rs;
		}
		model.setOrderStatus(3);
		tlabOrderMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","拒绝预约成功");
		return rs;
	}
}
