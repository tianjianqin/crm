package com.crm.system.mapper;


import com.crm.base.web.BaseRepository;
import com.crm.system.domain.Department;
import com.crm.system.domain.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper  extends BaseRepository<Department> {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}