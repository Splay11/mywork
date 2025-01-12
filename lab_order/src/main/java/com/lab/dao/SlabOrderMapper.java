package com.lab.dao;
import com.lab.model.SlabOrder;
import com.lab.model.SlabOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface SlabOrderMapper {
	long countByExample(SlabOrderExample example);
	int deleteByExample(SlabOrderExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(SlabOrder record);
	int insertSelective(SlabOrder record);
	List<SlabOrder> selectByExample(SlabOrderExample example);
	SlabOrder selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") SlabOrder record, @Param("example") SlabOrderExample example);
	int updateByExample(@Param("record") SlabOrder record, @Param("example") SlabOrderExample example);
	int updateByPrimaryKeySelective(SlabOrder record);
	int updateByPrimaryKey(SlabOrder record);
}
