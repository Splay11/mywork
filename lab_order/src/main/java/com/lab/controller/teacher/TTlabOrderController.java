package com.lab.controller.teacher;
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
@RequestMapping("/teacher/tlab_order")
public class TTlabOrderController{
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
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
	public void getList(Map<String,Object> rs ,LoginModel login){
		CourseMsgExample courseMsgE = new CourseMsgExample();
		List<CourseMsg> courseMsgList=courseMsgMapper.selectByExample(courseMsgE);
		List<Map<String,Object>>  courseMsgList2 = new ArrayList<Map<String,Object>>();
		for(CourseMsg m:courseMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getCname());
			courseMsgList2.add(map);
		}
		rs.put("courseMsgList",courseMsgList2);
		rs.put("orderTimeList",DataListUtils.getOrderTimeList());//返回order_time列表
		rs.put("orderStatusList",DataListUtils.getOrderStatusList());//返回order_status列表
	}
	/**
	* 根据查询条件分页查询教师实验预约数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(TlabOrder model,Integer page,String orderDate1,String orderDate2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setTeacherId(login.getId());//教师ID等于当前登录id
		return tlabOrderService.getDataListCount(orderDate1,orderDate2,model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,Integer roomId,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		Teacher teacher = teacherMapper.selectByPrimaryKey(login.getId());
		rs.put("user",teacher);
		TlabOrder model = new TlabOrder();
		model.setRoomId(roomId);
		rs.put("data",model);
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
		model.setTeacherId(login.getId());//教师ID等于当前登录id
		return tlabOrderService.getDataList(orderDate1,orderDate2,model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("add")
	@ResponseBody
	public Object add(TlabOrder model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		getList( rs,login);//获取前台需要用到的数据列表并返回给前台
		rs.put("data",model);
		rs.put("code",1);
		return rs;
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(TlabOrder model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = tlabOrderService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("update")
	@ResponseBody
	public Object update(TlabOrder model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		getList( rs,login);//获取前台需要用到的数据列表并返回给前台
		TlabOrder data = tlabOrderMapper.selectByPrimaryKey(model.getId());
		rs.put("data",data);
		rs.put("code",1);
		return rs;
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(TlabOrder model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = tlabOrderService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除教师实验预约接口
	*/
	@RequestMapping("del1")
	@ResponseBody
	public Object del1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		tlabOrderService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "qxyy")
	@ResponseBody
	public Object qxyy(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		TlabOrder model = tlabOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该教师实验预约已不存在");
			return rs;
		}
		model.setOrderStatus(4);
		tlabOrderMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","取消预约成功");
		return rs;
	}
}
