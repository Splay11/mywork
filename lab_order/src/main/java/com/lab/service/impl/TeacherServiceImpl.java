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
public class TeacherServiceImpl implements TeacherService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	@Autowired
	TeacherMapper teacherMapper;
	/**
	新增
	*/
	@Override
	public String add(Teacher model,LoginModel login){
		if(model.getTno()==null||model.getTno().equals("")){
			return "工号为必填属性";
		}
		if(model.getTno()!=null){
			TeacherExample te=new TeacherExample();
			TeacherExample.Criteria tc=te.createCriteria();
			tc.andTnoEqualTo(model.getTno());
			int count = (int)teacherMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 工号 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getJobLevel()==null||model.getJobLevel().equals("")){
			return "职称为必填属性";
		}
		if(model.getCid()==null){
			return "所属学院为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		teacherMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Teacher model,LoginModel login){
		Teacher preModel = teacherMapper.selectByPrimaryKey(model.getId());
		if(model.getTno()==null||model.getTno().equals("")){
			return "工号为必填属性";
		}
		if(model.getTno()!=null){
			TeacherExample te=new TeacherExample();
			TeacherExample.Criteria tc=te.createCriteria();
			tc.andTnoEqualTo(model.getTno());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)teacherMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 工号 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getJobLevel()==null||model.getJobLevel().equals("")){
			return "职称为必填属性";
		}
		if(model.getCid()==null){
			return "所属学院为必填属性";
		}
		preModel.setTno(model.getTno());
		preModel.setPassword(model.getPassword());
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setJobLevel(model.getJobLevel());
		preModel.setCid(model.getCid());
		teacherMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(Teacher model,LoginModel login){
		Teacher preModel = teacherMapper.selectByPrimaryKey(model.getId());
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getJobLevel()==null||model.getJobLevel().equals("")){
			return "职称为必填属性";
		}
		if(model.getCid()==null){
			return "所属学院为必填属性";
		}
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setJobLevel(model.getJobLevel());
		preModel.setCid(model.getCid());
		teacherMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询教师列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Teacher queryModel,Integer pageSize,LoginModel login) {
		TeacherExample se = new TeacherExample();
		TeacherExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getTno()!=null&&queryModel.getTno().equals("")==false){
			sc.andTnoLike("%"+queryModel.getTno()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)teacherMapper.countByExample(se);
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
	*根据参数查询教师列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Teacher queryModel,Integer page,Integer pageSize,LoginModel login) {
		TeacherExample se = new TeacherExample();
		TeacherExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getTno()!=null&&queryModel.getTno().equals("")==false){
			sc.andTnoLike("%"+queryModel.getTno()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Teacher> list = teacherMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Teacher model:list){
			list2.add(getTeacherModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装教师为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getTeacherModel(Teacher model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacher",model);
		if(model.getCid()!=null){
			CollegeMsg collegeMsg = collegeMsgMapper.selectByPrimaryKey(model.getCid());//所属学院为外接字段，需要关联学院来解释该字段
			if(collegeMsg!=null){
				map.put("cidStr",collegeMsg.getCname());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		teacherMapper.deleteByPrimaryKey(id);
	}
}
