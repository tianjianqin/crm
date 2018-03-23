package com.crm.custom.domain;

import java.util.Date;

public class Custominfo {
    private Integer id;

    private Integer customid;

    private String name;

    private Integer followmanid;

    private String followman;

    private String statu;

    private Date startdate;

    private Date lastfollowdate;

    private Date plandate;

    private String mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowman() {
        return followman;
    }

    public void setFollowman(String followman) {
        this.followman = followman;
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

    public Integer getFollowmanid() {
        return followmanid;
    }

    public void setFollowmanid(Integer followmanid) {
        this.followmanid = followmanid;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getLastfollowdate() {
        return lastfollowdate;
    }

    public void setLastfollowdate(Date lastfollowdate) {
        this.lastfollowdate = lastfollowdate;
    }

    public Date getPlandate() {
        return plandate;
    }

    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}