package com.crm.custom.mapper;

import com.crm.base.web.BaseRepository;
import com.crm.custom.domain.Custominfo;
import com.crm.custom.domain.CustominfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustominfoMapper extends BaseRepository<Custominfo>{
    long countByExample(CustominfoExample example);

    int deleteByExample(CustominfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Custominfo record);

    int insertSelective(Custominfo record);

    List<Custominfo> selectByExample(CustominfoExample example);

    Custominfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Custominfo record, @Param("example") CustominfoExample example);

    int updateByExample(@Param("record") Custominfo record, @Param("example") CustominfoExample example);

    int updateByPrimaryKeySelective(Custominfo record);

    int updateByPrimaryKey(Custominfo record);

    List<Custominfo> queryHistory(Map<String, Object> map);

    int queryHistoryTotal(Map<String, Object> map);

    List<Custominfo> queryMonth(Map<String, Object> map);

    int queryMonthTotal(Map<String, Object> map);

}