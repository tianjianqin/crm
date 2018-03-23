package com.crm.custom.service.impl;

import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.Custom;
import com.crm.custom.mapper.ConsultrecordMapper;
import com.crm.custom.mapper.CustomMapper;
import com.crm.custom.service.ConsultrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:39
 */
@Service
@Transactional
public class ConsultrecordServiceImpl implements ConsultrecordService{

    @Autowired
    private CustomMapper customMapper;
    @Autowired
    private ConsultrecordMapper consultrecordMapper;

    @Override
    public void saveOrUpdate(List<Custom> customList, List<Consultrecord> consultrecordList) {
        for(Custom c:customList){
            customMapper.update(c);
        }
        consultrecordMapper.saveBatch(consultrecordList);
    }
}
