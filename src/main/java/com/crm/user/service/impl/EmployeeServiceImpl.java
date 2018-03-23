package com.crm.user.service.impl;

import com.crm.system.domain.Department;
import com.crm.system.domain.Jobinfo;
import com.crm.system.mapper.DepartmentMapper;
import com.crm.system.mapper.JobinfoMapper;
import com.crm.user.domain.Employee;
import com.crm.user.domain.EmployeeExample;
import com.crm.user.mapper.EmployeeMapper;
import com.crm.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/2/28 15:24
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private JobinfoMapper jobinfoMapper;
    /*//修改用户密码
    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }*/


    //查询所有员工信息
    public List<Employee> findAllEmployee(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andJobinfoidNotEqualTo(id);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        List<Employee> employeeList1 = new ArrayList<Employee>();
        for (Employee e : employeeList) {
            Department department = departmentMapper.selectByPrimaryKey(e.getDepartmentid());
            Jobinfo jobinfo = jobinfoMapper.selectByPrimaryKey(e.getJobinfoid());
            e.setDname(department.getDname());
            e.setJob(jobinfo.getJob());
            employeeList1.add(e);
        }
        return employeeList1;
    }

    @Override
    public List<Employee> queryList(Map<String, Object> map) {
        return employeeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return employeeMapper.queryTotal(map);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }
}
