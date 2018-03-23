package com.crm.custom.mapper;

import com.crm.base.web.BaseRepository;
import com.crm.custom.domain.Custom;
import com.crm.custom.domain.CustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper extends BaseRepository<Custom>{
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    //批量更新
//    int updateBatch(@Param("customstatu") String customstatu, @Param("customList") List<Custom> customList);

    Custom queryByNameAndPhone(Custom custom);
}