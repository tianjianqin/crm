package com.crm.custom.domain;

import java.util.Date;

public class Consultrecord {
    private Integer id;

    private Integer customid;

    private String customname;

    private Integer consultmanid;

    private String consultman;

    private String consultstatu;

    private Date consultdate;

    private String result;

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
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