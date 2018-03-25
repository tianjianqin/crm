package com.crm.custom.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Consultrecord {
    private Integer id;

    private Integer customid;

    private String name;

    private Integer consultmanid;

    private String consultman;

    private String consultstatu;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consultdate;

    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsultman() {
        return consultman;
    }

    public void setConsultman(String consultman) {
        this.consultman = consultman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomid() {
        return customid;
    }

    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    public Integer getConsultmanid() {
        return consultmanid;
    }

    public void setConsultmanid(Integer consultmanid) {
        this.consultmanid = consultmanid;
    }

    public String getConsultstatu() {
        return consultstatu;
    }

    public void setConsultstatu(String consultstatu) {
        this.consultstatu = consultstatu;
    }

    public Date getConsultdate() {
        return consultdate;
    }

    public void setConsultdate(Date consultdate) {
        this.consultdate = consultdate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}