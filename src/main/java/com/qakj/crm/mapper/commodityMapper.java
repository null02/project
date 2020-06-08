package com.qakj.crm.mapper;

import com.qakj.crm.pojo.commodity;
import com.qakj.crm.pojo.commodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface commodityMapper {
    int countByExample(commodityExample example);

    int deleteByExample(commodityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(commodity record);

    int insertSelective(commodity record);

    List<commodity> selectByExample(commodityExample example);

    commodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") commodity record, @Param("example") commodityExample example);

    int updateByExample(@Param("record") commodity record, @Param("example") commodityExample example);

    int updateByPrimaryKeySelective(commodity record);

    int updateByPrimaryKey(commodity record);
}