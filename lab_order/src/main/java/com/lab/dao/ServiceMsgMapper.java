package com.lab.dao;
import com.lab.model.ServiceMsg;
import com.lab.model.ServiceMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface ServiceMsgMapper {
	long countByExample(ServiceMsgExample example);
	int deleteByExample(ServiceMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(ServiceMsg record);
	int insertSelective(ServiceMsg record);
	List<ServiceMsg> selectByExample(ServiceMsgExample example);
	ServiceMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") ServiceMsg record, @Param("example") ServiceMsgExample example);
	int updateByExample(@Param("record") ServiceMsg record, @Param("example") ServiceMsgExample example);
	int updateByPrimaryKeySelective(ServiceMsg record);
	int updateByPrimaryKey(ServiceMsg record);
}
