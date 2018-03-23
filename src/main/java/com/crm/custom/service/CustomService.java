package com.crm.custom.service;

import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/19 10:22
 */
public interface CustomService {

    List<Custom> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void update(Custom custom);

    void save(Custom custom);

    void delete(Integer id);

    Custom queryByNameAndPhone(Custom custom);


}
