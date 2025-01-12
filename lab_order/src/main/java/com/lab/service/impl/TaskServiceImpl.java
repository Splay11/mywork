package com.lab.service.impl;
import java.util.Map;
import java.util.HashMap;
import com.lab.controller.LoginModel;
import com.lab.model.*;
import com.lab.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.lab.service.*;
import  java.io.InputStream;
import   java.text.SimpleDateFormat;
import  com.lab.util.*;
import   org.springframework.ui.ModelMap;
import   java.util.regex.Pattern;
import  java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
@Service
public class TaskServiceImpl implements TaskService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	OrderGatherMapper orderGatherMapper;
	@Autowired
	SlabOrderMapper slabOrderMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TlabOrderMapper tlabOrderMapper;
	
	
	@Override
	public void taskService(){
		OrderGatherExample oe = new OrderGatherExample();
		orderGatherMapper.deleteByExample(oe);
		List<Map<String,Object>> jsList = DataListUtils.getOrderTimeList();
		CollegeMsgExample ce = new CollegeMsgExample();
		List<CollegeMsg> cl = collegeMsgMapper.selectByExample(ce);
		for(CollegeMsg c:cl) {
			for(Map<String,Object> j:jsList) {
				SlabOrderExample se = new SlabOrderExample();
				SlabOrderExample.Criteria sc =se.createCriteria();
				sc.andOrderTimeEqualTo(Integer.parseInt(j.get("id").toString()));
				sc.andCollegeIdEqualTo(c.getId());
				int count = (int) slabOrderMapper.countByExample(se);
				
				TlabOrderExample se2 = new TlabOrderExample();
				TlabOrderExample.Criteria sc2 =se2.createCriteria();
				sc2.andOrderTimeEqualTo(Integer.parseInt(j.get("id").toString()));
				sc2.andCollegeIdEqualTo(c.getId());
				int count2 = (int) tlabOrderMapper.countByExample(se2);
				
				OrderGather g = new OrderGather();
				g.setCourseTime(Integer.parseInt(j.get("id").toString()));
				g.setCollegeId(c.getId());
				g.setNum(count+count2);
				orderGatherMapper.insertSelective(g);
				
				
			}
		}
	}
}
