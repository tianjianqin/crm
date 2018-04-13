package com.crm.system.controller;

import com.crm.base.utils.DateUtils;
import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.base.utils.excel.ExportExcel;
import com.crm.custom.domain.Custom;
import com.crm.custom.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/4/12 17:12
 */
@RestController
public class ExportController {


    @Autowired
    private CustomService customService;

    @RequestMapping("export")
    public Result exportFile(@RequestParam Map<String, Object> params, HttpServletResponse response) throws IOException {

        String fileName = "客户数据"+ DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
        Query query = new Query(params);
        List<Custom> customList = customService.queryList(query);
        (new ExportExcel("客户数据",Custom.class)).setDataList(customList).write(response, fileName).dispose();
        return Result.ok();
    }
}
