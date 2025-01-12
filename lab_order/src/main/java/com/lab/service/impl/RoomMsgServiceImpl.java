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
public class RoomMsgServiceImpl implements RoomMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	ManageMapper manageMapper;
	/**
	新增
	*/
	@Override
	public String add(RoomMsg model,LoginModel login){
		if(model.getRoomName()==null||model.getRoomName().equals("")){
			return "讲座名称为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "讲座地点为必填属性";
		}
		if(model.getManageId()==null){
			return "负责管理员为必填属性";
		}
		if(model.getMaxNum()==null){
			return "可容纳人数为必填属性";
		}
		if(model.getRoomType()==null){
			return "讲座类型为必填属性";
		}
		roomMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(RoomMsg model,LoginModel login){
		RoomMsg preModel = roomMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getRoomName()==null||model.getRoomName().equals("")){
			return "实验室名称为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "实验室地点为必填属性";
		}
		if(model.getManageId()==null){
			return "负责管理员为必填属性";
		}
		if(model.getMaxNum()==null){
			return "可容纳人数为必填属性";
		}
		if(model.getRoomType()==null){
			return "实验室类型为必填属性";
		}
		preModel.setRoomName(model.getRoomName());
		preModel.setAddress(model.getAddress());
		preModel.setManageId(model.getManageId());
		preModel.setMaxNum(model.getMaxNum());
		preModel.setRemark(model.getRemark());
		preModel.setRoomType(model.getRoomType());
		roomMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询实验室列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(RoomMsg queryModel,Integer pageSize,LoginModel login) {
		RoomMsgExample se = new RoomMsgExample();
		RoomMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomName()!=null&&queryModel.getRoomName().equals("")==false){
			sc.andRoomNameLike("%"+queryModel.getRoomName()+"%");//模糊查询
		}
		if(queryModel.getRoomType()!=null){
			sc.andRoomTypeEqualTo(queryModel.getRoomType());//查询实验室类型等于指定值
		}
		if(queryModel.getManageId()!=null){
			sc.andManageIdEqualTo(queryModel.getManageId());
		}
		int count = (int)roomMsgMapper.countByExample(se);
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
	*根据参数查询实验室列表数据
	*/
	@Override
	public Map<String,Object> getDataList(RoomMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		RoomMsgExample se = new RoomMsgExample();
		RoomMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getRoomName()!=null&&queryModel.getRoomName().equals("")==false){
			sc.andRoomNameLike("%"+queryModel.getRoomName()+"%");//模糊查询
		}
		if(queryModel.getRoomType()!=null){
			sc.andRoomTypeEqualTo(queryModel.getRoomType());//查询实验室类型等于指定值
		}
		if(queryModel.getManageId()!=null){
			sc.andManageIdEqualTo(queryModel.getManageId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<RoomMsg> list = roomMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(RoomMsg model:list){
			list2.add(getRoomMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装实验室为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getRoomMsgModel(RoomMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomMsg",model);
		if(model.getManageId()!=null){
			Manage manage = manageMapper.selectByPrimaryKey(model.getManageId());//负责管理员为外接字段，需要关联实验室管理员来解释该字段
			if(manage!=null){
				map.put("manageIdStr",manage.getLoginName());
			}
		}
		map.put("roomTypeStr",DataListUtils.getRoomTypeNameById(model.getRoomType()+""));//解释实验室类型字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		roomMsgMapper.deleteByPrimaryKey(id);
	}
}
