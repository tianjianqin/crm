package com.crm.custom.service;

import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.Custom;

import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:37
 */
public interface ConsultrecordService {

    void saveOrUpdate(List<Custom> customList, List<Consultrecord> consultrecordList);
}
