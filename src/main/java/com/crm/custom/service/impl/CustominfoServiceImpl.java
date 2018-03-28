package com.crm.custom.service.impl;

import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;
import com.crm.custom.mapper.CustomMapper;
import com.crm.custom.mapper.CustominfoMapper;
import com.crm.custom.service.CustominfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/22 14:35
 */
@Service
@Transactional
public class CustominfoServiceImpl implements CustominfoService {

    @Autowired
    private CustominfoMapper custominfoMapper;
    @Autowired
    private CustomMapper customMapper;

    @Override
    public List<Custominfo> queryList(Map<String, Object> map) {
        return custominfoMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return custominfoMapper.queryTotal(map);
    }

    public void update(Custominfo custominfo) {
        if("4".equals(custominfo.getStatu())){
            Custom custom = new Custom();
            custom.setId(custominfo.getCustomid());
            custom.setCustomstatu(custominfo.getStatu());
            customMapper.update(custom);
        }
        custominfoMapper.update(custominfo);
    }

    @Override
    public List<Custominfo> queryHistory(Map<String, Object> map) {
        return custominfoMapper.queryHistory(map);
    }

    @Override
    public int queryHistoryTotal(Map<String, Object> map) {
        return custominfoMapper.queryHistoryTotal(map);
    }

    @Override
    public List<Custominfo> queryMonth(Map<String, Object> map) {

        return custominfoMapper.queryMonth(map);
    }

    @Override
    public int queryMonthTotal(Map<String, Object> map) {
        return custominfoMapper.queryMonthTotal(map);
    }

    @Override
    public void saveOrUpdate(List<Custom> customList, List<Custominfo> custominfoList) {
        for(Custom c:customList){
            customMapper.update(c);
        }
        custominfoMapper.saveBatch(custominfoList);
    }
}
