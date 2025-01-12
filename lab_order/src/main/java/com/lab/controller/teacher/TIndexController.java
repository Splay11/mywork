package com.lab.controller.teacher;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lab.controller.LoginModel;
import com.lab.util.CommonVal;
import  com.lab.model.*;
import com.lab.dao.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
@Controller
@RequestMapping("/teacher/index")
public class TIndexController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	TeacherMapper teacherMapper;
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		Teacher user = teacherMapper.selectByPrimaryKey(login.getId());
		rs.put("user", user);
		return rs;
	}
}
