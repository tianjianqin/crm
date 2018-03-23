package com.crm.user.service.impl;

import com.crm.user.domain.Employee;
import com.crm.user.domain.Resetpass;
import com.crm.user.mapper.EmployeeMapper;
import com.crm.user.mapper.ResetpassMapper;
import com.crm.user.service.ResetpassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianjianqin
 * @date 2018/3/19 16:11
 */
@Service
@Transactional
public class ResetpassServiceImpl implements ResetpassService{

    @Autowired
    private ResetpassMapper resetpassMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void save(Employee employee) {
        employeeMapper.update(employee);
        Resetpass resetpass = new Resetpass();
        resetpass.setUsername(employee.getUsername());
        resetpass.setPhoneno(employee.getPhoneno());
        resetpassMapper.save(resetpass);
    }
}
