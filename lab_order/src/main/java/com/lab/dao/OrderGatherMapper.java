package com.lab.dao;
import com.lab.model.OrderGather;
import com.lab.model.OrderGatherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface OrderGatherMapper {
	long countByExample(OrderGatherExample example);
	int deleteByExample(OrderGatherExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(OrderGather record);
	int insertSelective(OrderGather record);
	List<OrderGather> selectByExample(OrderGatherExample example);
	OrderGather selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") OrderGather record, @Param("example") OrderGatherExample example);
	int updateByExample(@Param("record") OrderGather record, @Param("example") OrderGatherExample example);
	int updateByPrimaryKeySelective(OrderGather record);
	int updateByPrimaryKey(OrderGather record);
}
