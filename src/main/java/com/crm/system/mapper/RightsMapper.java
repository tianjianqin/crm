package com.crm.system.mapper;


import com.crm.base.web.BaseRepository;
import com.crm.system.domain.Jobright;
import com.crm.system.domain.Rights;
import com.crm.system.domain.RightsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightsMapper extends BaseRepository<Rights>{
    long countByExample(RightsExample example);

    int deleteByExample(RightsExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Rights record);

    int insertSelective(Rights record);

    List<Rights> selectByExample(RightsExample example);

    Rights selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Rights record, @Param("example") RightsExample example);

    int updateByExample(@Param("record") Rights record, @Param("example") RightsExample example);

    int updateByPrimaryKeySelective(Rights record);

    int updateByPrimaryKey(Rights record);

    //批量查询
    List<Rights> batchSelectRights(List<Jobright> jobrights);
}