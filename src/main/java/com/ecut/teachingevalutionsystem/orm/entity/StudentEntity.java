package com.ecut.teachingevalutionsystem.orm.entity;


public class StudentEntity {
    public String stuId;
    public String stuNumberId;
    public String stuName;
    public String stuSex;
    public String stuInstitution;
    public String stuClass;
    public String del;
    public String loginPw;

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuNumberId() {
        return stuNumberId;
    }

    public void setStuNumberId(String stuNumberId) {
        this.stuNumberId = stuNumberId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuInstitution() {
        return stuInstitution;
    }

    public void setStuInstitution(String stuInstitution) {
        this.stuInstitution = stuInstitution;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "stuId='" + stuId + '\'' +
                ", stuNumberId='" + stuNumberId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuInstitution='" + stuInstitution + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}
