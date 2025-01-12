package com.lab.dao;
import com.lab.model.ClassMsg;
import com.lab.model.ClassMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface ClassMsgMapper {
	long countByExample(ClassMsgExample example);
	int deleteByExample(ClassMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(ClassMsg record);
	int insertSelective(ClassMsg record);
	List<ClassMsg> selectByExample(ClassMsgExample example);
	ClassMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") ClassMsg record, @Param("example") ClassMsgExample example);
	int updateByExample(@Param("record") ClassMsg record, @Param("example") ClassMsgExample example);
	int updateByPrimaryKeySelective(ClassMsg record);
	int updateByPrimaryKey(ClassMsg record);
}
