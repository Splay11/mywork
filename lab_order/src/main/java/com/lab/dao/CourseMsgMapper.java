package com.lab.dao;
import com.lab.model.CourseMsg;
import com.lab.model.CourseMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface CourseMsgMapper {
	long countByExample(CourseMsgExample example);
	int deleteByExample(CourseMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(CourseMsg record);
	int insertSelective(CourseMsg record);
	List<CourseMsg> selectByExample(CourseMsgExample example);
	CourseMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") CourseMsg record, @Param("example") CourseMsgExample example);
	int updateByExample(@Param("record") CourseMsg record, @Param("example") CourseMsgExample example);
	int updateByPrimaryKeySelective(CourseMsg record);
	int updateByPrimaryKey(CourseMsg record);
}
