package com.lab.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lab.controller.LoginModel;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lab.util.CommonVal;
import  com.lab.model.*;
import com.lab.dao.*;
import com.lab.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
@Controller
@RequestMapping("/regist")
public class RegistController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@RequestMapping("getListData")
	@ResponseBody
	public Object getListData(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> sexList = DataListUtils.getSexList();
		rs.put("sexList",sexList);
		CollegeMsgExample collegeMsgE = new CollegeMsgExample();
		List<CollegeMsg> collegeMsgList = collegeMsgMapper.selectByExample(collegeMsgE);
		List<Map<String,Object>>  collegeMsgList2 = new ArrayList<Map<String,Object>>();
		for(CollegeMsg m:collegeMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getCname());
			collegeMsgList2.add(map);
		}
		rs.put("collegeMsgList",collegeMsgList2);
		return rs;
	}
}
