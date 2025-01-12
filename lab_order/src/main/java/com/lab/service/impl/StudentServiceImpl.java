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
public class StudentServiceImpl implements StudentService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	CollegeMsgMapper collegeMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(Student model,LoginModel login){
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentExample te=new StudentExample();
			StudentExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			int count = (int)studentMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
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
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getStuType()==null){
			return "学生类型为必填属性";
		}
		if(model.getCid()==null){
			return "学院为必填属性";
		}
		if(model.getClassName()==null||model.getClassName().equals("")){
			return "班级为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		studentMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	新增
	*/
	@Override
	public String add1(Student model,LoginModel login){
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentExample te=new StudentExample();
			StudentExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			int count = (int)studentMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
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
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getStuType()==null){
			return "学生类型为必填属性";
		}
		if(model.getCid()==null){
			return "学院为必填属性";
		}
		if(model.getClassName()==null||model.getClassName().equals("")){
			return "班级为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		studentMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Student model,LoginModel login){
		Student preModel = studentMapper.selectByPrimaryKey(model.getId());
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentExample te=new StudentExample();
			StudentExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)studentMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
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
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getStuType()==null){
			return "学生类型为必填属性";
		}
		if(model.getCid()==null){
			return "学院为必填属性";
		}
		if(model.getClassName()==null||model.getClassName().equals("")){
			return "班级为必填属性";
		}
		preModel.setStuNo(model.getStuNo());
		preModel.setPassword(model.getPassword());
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setEmail(model.getEmail());
		preModel.setSex(model.getSex());
		preModel.setStuType(model.getStuType());
		preModel.setCid(model.getCid());
		preModel.setClassName(model.getClassName());
		studentMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(Student model,LoginModel login){
		Student preModel = studentMapper.selectByPrimaryKey(model.getId());
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
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getStuType()==null){
			return "学生类型为必填属性";
		}
		if(model.getCid()==null){
			return "学院为必填属性";
		}
		if(model.getClassName()==null||model.getClassName().equals("")){
			return "班级为必填属性";
		}
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setEmail(model.getEmail());
		preModel.setSex(model.getSex());
		preModel.setStuType(model.getStuType());
		preModel.setCid(model.getCid());
		preModel.setClassName(model.getClassName());
		studentMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update2(Student model,LoginModel login){
		Student preModel = studentMapper.selectByPrimaryKey(model.getId());
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentExample te=new StudentExample();
			StudentExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)studentMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
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
		if(model.getEmail()==null||model.getEmail().equals("")){
			return "邮箱为必填属性";
		}
		if(model.getEmail()!=null){
		Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(model.getEmail());
			if( m.matches()==false){
				return "请输入正确的邮箱";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getStuType()==null){
			return "学生类型为必填属性";
		}
		if(model.getCid()==null){
			return "学院为必填属性";
		}
		if(model.getClassName()==null||model.getClassName().equals("")){
			return "班级为必填属性";
		}
		preModel.setStuNo(model.getStuNo());
		preModel.setPassword(model.getPassword());
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setEmail(model.getEmail());
		preModel.setSex(model.getSex());
		preModel.setStuType(model.getStuType());
		preModel.setCid(model.getCid());
		preModel.setClassName(model.getClassName());
		studentMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询学生列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Student queryModel,Integer pageSize,LoginModel login) {
		StudentExample se = new StudentExample();
		StudentExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getStuNo()!=null&&queryModel.getStuNo().equals("")==false){
			sc.andStuNoLike("%"+queryModel.getStuNo()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getStuType()!=null){
			sc.andStuTypeEqualTo(queryModel.getStuType());//查询学生类型等于指定值
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)studentMapper.countByExample(se);
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
	*根据参数查询学生列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Student queryModel,Integer page,Integer pageSize,LoginModel login) {
		StudentExample se = new StudentExample();
		StudentExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getStuNo()!=null&&queryModel.getStuNo().equals("")==false){
			sc.andStuNoLike("%"+queryModel.getStuNo()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getStuType()!=null){
			sc.andStuTypeEqualTo(queryModel.getStuType());//查询学生类型等于指定值
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Student> list = studentMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Student model:list){
			list2.add(getStudentModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装学生为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getStudentModel(Student model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("student",model);
		map.put("sexStr",DataListUtils.getSexNameById(model.getSex()+""));//解释性别字段
		map.put("stuTypeStr",DataListUtils.getStuTypeNameById(model.getStuType()+""));//解释学生类型字段
		if(model.getCid()!=null){
			CollegeMsg collegeMsg = collegeMsgMapper.selectByPrimaryKey(model.getCid());//学院为外接字段，需要关联学院来解释该字段
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
		studentMapper.deleteByPrimaryKey(id);
	}
}
