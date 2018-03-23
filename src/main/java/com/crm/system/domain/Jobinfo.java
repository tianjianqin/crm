package com.crm.system.domain;

import java.util.List;

public class Jobinfo {
    private Integer id;

    private String job;

    private Integer departmentid;

    private String remarks;

    private String dname;

    private List<Integer> rightIdList;

    public List<Integer> getRightIdList() {
        return rightIdList;
    }

    public void setRightIdList(List<Integer> rightIdList) {
        this.rightIdList = rightIdList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }
}