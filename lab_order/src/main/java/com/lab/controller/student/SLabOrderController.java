package com.lab.controller.student;
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
@RequestMapping("/student/lab_order")
public class SLabOrderController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	LabOrderService labOrderService;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	LabOrderMapper labOrderMapper;
	/**
	* 根据查询条件分页查询实验室预约数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(LabOrder model,Integer page,String orderDate1,String orderDate2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return labOrderService.getDataListCount(orderDate1,orderDate2,model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,Integer roomId,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		Student student = studentMapper.selectByPrimaryKey(login.getId());
		rs.put("user",student);
		LabOrder model = new LabOrder();
		model.setRoomId(roomId);
		rs.put("data",model);
		return rs;
	}
	/**
	* 根据查询条件分页查询实验室预约数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(LabOrder model,Integer page,String orderDate1,String orderDate2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return labOrderService.getDataList(orderDate1,orderDate2,model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
