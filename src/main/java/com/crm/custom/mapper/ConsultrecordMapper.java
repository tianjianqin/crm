package com.crm.custom.mapper;

import com.crm.base.web.BaseRepository;
import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.ConsultrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ConsultrecordMapper extends BaseRepository<Consultrecord>{
    long countByExample(ConsultrecordExample example);

    int deleteByExample(ConsultrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Consultrecord record);

    int insertSelective(Consultrecord record);

    List<Consultrecord> selectByExample(ConsultrecordExample example);

    Consultrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consultrecord record, @Param("example") ConsultrecordExample example);

    int updateByExample(@Param("record") Consultrecord record, @Param("example") ConsultrecordExample example);

    int updateByPrimaryKeySelective(Consultrecord record);

    int updateByPrimaryKey(Consultrecord record);

    List<Consultrecord> queryHistory(Map<String, Object> map);

    int queryHistoryTotal(Map<String, Object> map);

    List<Consultrecord> queryMonth(Map<String, Object> map);

    int queryMonthTotal(Map<String, Object> map);
}