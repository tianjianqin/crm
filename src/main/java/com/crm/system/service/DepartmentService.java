package com.crm.system.service;

import com.crm.system.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/6 17:26
 */
public interface DepartmentService {

    List<Department> queryList(Map<String, Object> map);
}
