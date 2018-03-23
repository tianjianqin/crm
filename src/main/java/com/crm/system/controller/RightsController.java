package com.crm.system.controller;

import com.crm.base.utils.Result;
import com.crm.system.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianjianqin
 * @date 2018/3/9 17:43
 */
@RestController
@RequestMapping("rights")
public class RightsController {

    @Autowired
    private RightsService rightsService;

}
