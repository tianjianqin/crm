package com.crm.system.mapper;

import com.crm.base.web.BaseRepository;
import com.crm.system.domain.Jobright;
import com.crm.system.domain.JobrightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobrightMapper extends BaseRepository<Jobright>{
    long countByExample(JobrightExample example);

    int deleteByExample(JobrightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jobright record);

    int insertSelective(Jobright record);

    List<Jobright> selectByExample(JobrightExample example);

    Jobright selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jobright record, @Param("example") JobrightExample example);

    int updateByExample(@Param("record") Jobright record, @Param("example") JobrightExample example);

    int updateByPrimaryKeySelective(Jobright record);

    int updateByPrimaryKey(Jobright record);

    List<Integer> queryRightIdList(Integer jobInfoId);
}