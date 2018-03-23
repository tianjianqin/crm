package com.crm.system.service;

import com.crm.user.domain.Employee;

/**
 * @author tianjianqin@senyint.com.cn
 * @date 2018/2/26 17:20
 */
public interface SysUserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Employee login(String username, String password);


}
