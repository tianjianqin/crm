package com.crm.system.service.impl;

import com.crm.system.domain.Department;
import com.crm.system.mapper.DepartmentMapper;
import com.crm.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/6 17:31
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> queryList(Map<String, Object> map) {
        return departmentMapper.queryList(map);
    }

}
