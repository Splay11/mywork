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
@RequestMapping("/teacher/teacher")
public class TTeacherController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	TeacherService teacherService;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
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
	}
	/**
	获取教师详情页数据
	*/
	@RequestMapping("getDetailData")
	@ResponseBody
	public Object getDetailData(HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Teacher model = new Teacher();
		model.setId(login.getId());
		Teacher preModel = teacherMapper.selectByPrimaryKey(login.getId());
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("detail",teacherService.getTeacherModel(preModel,login));
		return rs;
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("update1")
	@ResponseBody
	public Object update1(Teacher model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		getList( rs,login);//获取前台需要用到的数据列表并返回给前台
		Teacher data = teacherMapper.selectByPrimaryKey(model.getId());
		rs.put("data",data);
		rs.put("code",1);
		return rs;
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update1_submit")
	@ResponseBody
	public Object update1_submit(Teacher model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = teacherService.update1(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
}
