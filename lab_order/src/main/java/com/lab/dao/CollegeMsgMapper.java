package com.lab.dao;
import com.lab.model.CollegeMsg;
import com.lab.model.CollegeMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface CollegeMsgMapper {
	long countByExample(CollegeMsgExample example);
	int deleteByExample(CollegeMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(CollegeMsg record);
	int insertSelective(CollegeMsg record);
	List<CollegeMsg> selectByExample(CollegeMsgExample example);
	CollegeMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") CollegeMsg record, @Param("example") CollegeMsgExample example);
	int updateByExample(@Param("record") CollegeMsg record, @Param("example") CollegeMsgExample example);
	int updateByPrimaryKeySelective(CollegeMsg record);
	int updateByPrimaryKey(CollegeMsg record);
}
