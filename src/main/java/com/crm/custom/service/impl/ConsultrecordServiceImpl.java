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
import java.util.Map;

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

    public List<Consultrecord> queryList(Map<String, Object> map) {
        return consultrecordMapper.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return consultrecordMapper.queryTotal(map);
    }

    public void update(Consultrecord consultrecord) {
        if("3".equals(consultrecord.getConsultstatu())){
            Custom custom = new Custom();
            custom.setId(consultrecord.getCustomid());
            custom.setCustomstatu("4");
            customMapper.update(custom);
        }
        consultrecordMapper.update(consultrecord);
    }

    @Override
    public List<Consultrecord> queryHistory(Map<String, Object> map) {
        return consultrecordMapper.queryHistory(map);
    }

    @Override
    public int queryHistoryTotal(Map<String, Object> map) {
        return consultrecordMapper.queryHistoryTotal(map);
    }

    @Override
    public List<Consultrecord> queryMonth(Map<String, Object> map) {
        return consultrecordMapper.queryMonth(map);
    }

    @Override
    public int queryMonthTotal(Map<String, Object> map) {
        return consultrecordMapper.queryMonthTotal(map);
    }
}
