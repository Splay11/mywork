package com.lab.dao;
import com.lab.model.LabOrder;
import com.lab.model.LabOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface LabOrderMapper {
	long countByExample(LabOrderExample example);
	int deleteByExample(LabOrderExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(LabOrder record);
	int insertSelective(LabOrder record);
	List<LabOrder> selectByExample(LabOrderExample example);
	LabOrder selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") LabOrder record, @Param("example") LabOrderExample example);
	int updateByExample(@Param("record") LabOrder record, @Param("example") LabOrderExample example);
	int updateByPrimaryKeySelective(LabOrder record);
	int updateByPrimaryKey(LabOrder record);
}
