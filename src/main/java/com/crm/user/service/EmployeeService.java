package com.crm.user.service;

import com.crm.user.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/2/28 15:15
 */
public interface EmployeeService {


   /* *//**
     * 修改用户密码信息
     * @param employee
     *//*
    void update(Employee employee);*/

    /**
     * 查询所有员工信息
     *
     * @return
     */
    List<Employee> findAllEmployee(Integer id);


    List<Employee> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);


    void update(Employee employee);

    void save(Employee employee);
}
