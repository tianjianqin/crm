package com.crm.custom.service;

import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/22 14:33
 */
public interface CustominfoService {

    void saveOrUpdate(List<Custom> customList, List<Custominfo> custominfoList);

    List<Custominfo> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void update(Custominfo custominfo);


    List<Custominfo> queryHistory(Map<String, Object> map);

    int queryHistoryTotal(Map<String, Object> map);


    List<Custominfo> queryMonth(Map<String, Object> map);

    int queryMonthTotal(Map<String, Object> map);
}
