package com.crm.system.mapper;


import com.crm.base.web.BaseRepository;
import com.crm.system.domain.Jobinfo;
import com.crm.system.domain.JobinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobinfoMapper extends BaseRepository<Jobinfo> {
    long countByExample(JobinfoExample example);

    int deleteByExample(JobinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jobinfo record);

    int insertSelective(Jobinfo record);

    List<Jobinfo> selectByExample(JobinfoExample example);

    Jobinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jobinfo record, @Param("example") JobinfoExample example);

    int updateByExample(@Param("record") Jobinfo record, @Param("example") JobinfoExample example);

    int updateByPrimaryKeySelective(Jobinfo record);

    int updateByPrimaryKey(Jobinfo record);
}