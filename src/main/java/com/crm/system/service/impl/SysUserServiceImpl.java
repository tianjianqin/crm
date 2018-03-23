package com.crm.system.service.impl;

import com.crm.system.service.SysUserService;
import com.crm.user.domain.Employee;
import com.crm.user.domain.EmployeeExample;
import com.crm.user.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tianjianqin@senyint.com.cn
 * @date 2018/2/26 17:22
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private EmployeeMapper employeeMapper;

    //用户登录
    @Override
    public Employee login(String username,String password) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        if (employeeList.isEmpty()) {
            return null;
        } else {
            return employeeList.get(0);
        }
    }


}
