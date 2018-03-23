package com.crm.system.service;

import com.crm.system.domain.Jobinfo;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/8 14:46
 */
public interface JobinfoService {
    List<Jobinfo> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(Jobinfo jobinfo);

    void update(Jobinfo jobinfo);

    void delete(Integer id);

}
