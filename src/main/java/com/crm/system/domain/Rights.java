package com.crm.system.domain;

import java.io.Serializable;
import java.util.List;

public class Rights implements Serializable{
    private Integer rid;

    private String name;

    /**
     * 父菜单名称
     */
    private String parentname;

    private String righttype;

    private String url;

    private Integer pid;


    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRighttype() {
        return righttype;
    }

    public void setRighttype(String righttype) {
        this.righttype = righttype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "rid=" + rid +
                ", name='" + name + '\'' +
                ", parentname='" + parentname + '\'' +
                ", righttype='" + righttype + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                '}';
    }
}