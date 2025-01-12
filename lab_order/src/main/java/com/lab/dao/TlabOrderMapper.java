package com.lab.dao;
import com.lab.model.TlabOrder;
import com.lab.model.TlabOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface TlabOrderMapper {
	long countByExample(TlabOrderExample example);
	int deleteByExample(TlabOrderExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(TlabOrder record);
	int insertSelective(TlabOrder record);
	List<TlabOrder> selectByExample(TlabOrderExample example);
	TlabOrder selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") TlabOrder record, @Param("example") TlabOrderExample example);
	int updateByExample(@Param("record") TlabOrder record, @Param("example") TlabOrderExample example);
	int updateByPrimaryKeySelective(TlabOrder record);
	int updateByPrimaryKey(TlabOrder record);

	
}
