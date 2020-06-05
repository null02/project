package com.qakj.crm.mapper;

import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.pojo.LinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkmanMapper {
	
	List<Linkman> getLinkmans();
	
    int countByExample(LinkmanExample example);

    int deleteByExample(LinkmanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    List<Linkman> selectByExample(LinkmanExample example);

    Linkman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByExample(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}