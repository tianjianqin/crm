package com.crm.custom.domain;

import com.crm.base.utils.excel.annotation.ExcelField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Custom {
    private Integer id;

    private String name;

    private String education;

    private String phoneno;

    private String qq;

    private String email;

    private String customstatu;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    private String invitename;

    @ExcelField(
            title = "ID",
            type = 1,
            align = 2,
            sort = 1
    )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ExcelField(
            title = "客户姓名",
            align = 2,
            sort = 30
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ExcelField(
            title = "教育水平",
            align = 2,
            sort = 40
    )
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @ExcelField(
            title = "手机号",
            align = 2,
            sort = 70
    )
    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @ExcelField(
            title = "QQ",
            align = 2,
            sort = 70
    )
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @ExcelField(
            title = "邮箱",
            align = 1,
            sort = 50
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ExcelField(
            title = "客户状态",
            align = 2,
            sort = 80,
            dictType = "customStatu"
    )
    public String getCustomstatu() {
        return customstatu;
    }

    public void setCustomstatu(String customstatu) {
        this.customstatu = customstatu;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @ExcelField(
            title = "邀请人姓名",
            align = 2,
            sort = 30
    )
    public String getInvitename() {
        return invitename;
    }

    public void setInvitename(String invitename) {
        this.invitename = invitename;
    }

}