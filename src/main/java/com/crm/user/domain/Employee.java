package com.crm.user.domain;

public class Employee {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String realname;

    private Integer jobinfoid;

    private Integer departmentid;

    private String phoneno;

    private String officetel;

    private String workstatu;

    private String job;

    private String dname;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getJobinfoid() {
        return jobinfoid;
    }

    public void setJobinfoid(Integer jobinfoid) {
        this.jobinfoid = jobinfoid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getOfficetel() {
        return officetel;
    }

    public void setOfficetel(String officetel) {
        this.officetel = officetel;
    }

    public String getWorkstatu() {
        return this.workstatu;
    }

    public void setWorkstatu(String workstatu) {
        this.workstatu = workstatu;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", jobinfoid=" + jobinfoid +
                ", departmentid=" + departmentid +
                ", phoneno='" + phoneno + '\'' +
                ", officetel='" + officetel + '\'' +
                ", workstatu='" + workstatu + '\'' +
                '}';
    }
}