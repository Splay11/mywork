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
public class ServiceMsgServiceImpl implements ServiceMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	ServiceMsgMapper serviceMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(ServiceMsg model,LoginModel login){
		if(model.getServiceNae()==null||model.getServiceNae().equals("")){
			return "设备名为必填属性";
		}
		if(model.getServiceStatus()==null){
			return "设备状态为必填属性";
		}
		serviceMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	新增
	*/
	@Override
	public String add1(ServiceMsg model,LoginModel login){
		if(model.getServiceNae()==null||model.getServiceNae().equals("")){
			return "设备名为必填属性";
		}
		if(model.getServiceStatus()==null){
			return "设备状态为必填属性";
		}
		serviceMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(ServiceMsg model,LoginModel login){
		ServiceMsg preModel = serviceMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getServiceNae()==null||model.getServiceNae().equals("")){
			return "设备名为必填属性";
		}
		if(model.getServiceStatus()==null){
			return "设备状态为必填属性";
		}
		preModel.setServiceNae(model.getServiceNae());
		preModel.setServiceStatus(model.getServiceStatus());
		serviceMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(ServiceMsg model,LoginModel login){
		ServiceMsg preModel = serviceMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getServiceNae()==null||model.getServiceNae().equals("")){
			return "设备名为必填属性";
		}
		if(model.getServiceStatus()==null){
			return "设备状态为必填属性";
		}
		preModel.setServiceNae(model.getServiceNae());
		preModel.setServiceStatus(model.getServiceStatus());
		serviceMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询实验室设备列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(ServiceMsg queryModel,Integer pageSize,LoginModel login) {
		ServiceMsgExample se = new ServiceMsgExample();
		ServiceMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getServiceNae()!=null&&queryModel.getServiceNae().equals("")==false){
			sc.andServiceNaeLike("%"+queryModel.getServiceNae()+"%");//模糊查询
		}
		if(queryModel.getServiceStatus()!=null){
			sc.andServiceStatusEqualTo(queryModel.getServiceStatus());//查询设备状态等于指定值
		}
		int count = (int)serviceMsgMapper.countByExample(se);
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
	*根据参数查询实验室设备列表数据
	*/
	@Override
	public Map<String,Object> getDataList(ServiceMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		ServiceMsgExample se = new ServiceMsgExample();
		ServiceMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomId()!=null){
			sc.andRoomIdEqualTo(queryModel.getRoomId());
		}
		if(queryModel.getServiceNae()!=null&&queryModel.getServiceNae().equals("")==false){
			sc.andServiceNaeLike("%"+queryModel.getServiceNae()+"%");//模糊查询
		}
		if(queryModel.getServiceStatus()!=null){
			sc.andServiceStatusEqualTo(queryModel.getServiceStatus());//查询设备状态等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<ServiceMsg> list = serviceMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(ServiceMsg model:list){
			list2.add(getServiceMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装实验室设备为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getServiceMsgModel(ServiceMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("serviceMsg",model);
		map.put("serviceStatusStr",DataListUtils.getServiceStatusNameById(model.getServiceStatus()+""));//解释设备状态字段
		if(model.getRoomId()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRoomId());//所属实验室为外接字段，需要关联实验室来解释该字段
			if(roomMsg!=null){
				map.put("roomIdStr",roomMsg.getRoomName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		serviceMsgMapper.deleteByPrimaryKey(id);
	}
}
