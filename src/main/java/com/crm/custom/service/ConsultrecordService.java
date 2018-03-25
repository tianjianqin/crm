package com.crm.custom.service;

import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.Custom;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:37
 */
public interface ConsultrecordService {

    void saveOrUpdate(List<Custom> customList, List<Consultrecord> consultrecordList);

    List<Consultrecord> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void update(Consultrecord consultrecord);

}
