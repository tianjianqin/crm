package com.crm.system.controller;

import com.crm.base.utils.ReadExcel;
import com.crm.base.utils.Result;
import com.crm.base.utils.WDWUtil;
import com.crm.custom.domain.Custom;
import com.crm.custom.service.CustomService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/3/21 9:53
 */
@RestController
public class ImportController {

    @Autowired
    private CustomService customService;

    private static Log log = LogFactory.getLog(ImportController.class);
    /**
     * 访问controller进入操作页面
     * @return
     */
    @RequestMapping(value="/init")
    public void init(){
        System.out.println("控制台输出：初始化页面信息");
    }
    /**
     * 上传Excel,读取Excel中内容
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    public Result batchImport(@RequestParam MultipartFile file) throws IOException{
        log.info("ImportController ..batchimport() start");
        String Msg =null;
        boolean b = false;

        //判断文件是否为空
        if(file==null){
            Msg ="文件为空！";
        }

        //获取文件名
        String name=file.getOriginalFilename();

        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）验证文件名是否合格
        long size=file.getSize();
        if(!WDWUtil.validateExcel(name)){
            Msg ="文件格式不正确！请使用.xls或.xlsx后缀文档。";
            return Result.ok().put("msg",Msg);
        }

        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<Custom> newCustomList=new ArrayList<Custom>();
        List<Custom> customList = readExcel.getExcelInfo(file);
        if(customList != null && !customList.toString().equals("[]") && customList.size()>=1){
            b = true;
        }
        if(b){
            //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
            for(Custom custom:customList){
                //这里可以做添加数据库的功能
                System.out.println(custom);
                Custom allCustom = customService.queryByNameAndPhone(custom);
                if(allCustom==null){
                    custom.setCreatedate(new Date());
                    customService.save(custom);
                    newCustomList.add(custom);
                }
            }
            if(newCustomList.isEmpty()){
                Msg ="导入的信息已存在！";
            }else{
                Msg ="批量导入成功！";
            }
        }
        return Result.ok().put("msg",Msg);
    }


    /**
     * 下载Excel模板
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request,
                           HttpServletResponse response) {
        System.out.println("控制台输出：走入下载");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+ fileName);
        try {
            /*String path = Thread.currentThread().getContextClassLoader()
                    .getResource("").getPath()
                    + "download";//这个download目录为啥建立在classes下的
            */
            String path="D:\\upload";
            InputStream inputStream = new FileInputStream(new File(path+ File.separator + fileName));

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

}
