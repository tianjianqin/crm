package com.crm.system.controller;

import com.crm.system.domain.Rights;
import com.crm.system.service.JobRightService;
import com.crm.system.service.RightsService;
import com.crm.system.service.SysUserService;
import com.crm.user.domain.Employee;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/2/7 16:58
 */

@Controller
public class SysLoginController {

    @Autowired
    private Producer producer;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JobRightService jobRightService;
    /**
     * 验证码
     * @param response
     * @param session
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpSession session)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到session
        session.setAttribute("captcha",text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public String login(HttpSession session,String username, String password, String captcha)throws IOException {

        Employee employee = sysUserService.login(username, password);
        Object code = session.getAttribute("captcha");

        if(employee != null && employee.getWorkstatu().equals("1") || code.equals(captcha)){
            session.setAttribute("employee", employee);
            List<Rights> rightsList = jobRightService.findRightName(employee.getJobinfoid());
            session.setAttribute("rightsList",rightsList);
            return "1";
        }else if(employee == null){
            return "2";
        }else if(employee != null && employee.getWorkstatu().equals("1")&& !code.equals(captcha)){
            return "3";
        }else{//没有权限登录
            return "0";
        }
    }

    /**
     * 退出
     */
    @ResponseBody
    @RequestMapping(value = "sys/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "ok";
    }
}
