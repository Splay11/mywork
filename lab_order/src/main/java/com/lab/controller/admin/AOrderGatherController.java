package com.lab.controller.admin;
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
@RequestMapping("/admin/order_gather")
public class AOrderGatherController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	OrderGatherService orderGatherService;
	@Autowired
	OrderGatherMapper orderGatherMapper;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
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
		rs.put("orderTimeList",DataListUtils.getOrderTimeList());//返回order_time列表
	}
	/**
	* 根据查询条件分页查询预约汇总数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(OrderGather model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return orderGatherService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		rs.put("user",adminMsg);
		getList( rs,login);//获取数据列表并返回给前台
		return rs;
	}
	/**
	* 根据查询条件分页查询预约汇总数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(OrderGather model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return orderGatherService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	* 根据查询条件导出预约汇总数据,生成excel
	*/
	@RequestMapping(value="export_order")
	public void export_order(OrderGather model,Integer page,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> data =  orderGatherService.getDataList(model,page,CommonVal.pageSize,login);//获取数据列表，不分页
		orderGatherService.exportOrder( request,  response,data, login);
	}
}
