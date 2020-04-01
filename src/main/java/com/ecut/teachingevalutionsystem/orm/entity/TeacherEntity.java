package com.ecut.teachingevalutionsystem.orm.entity;

public class TeacherEntity {
    public String teaId;
    public String teaNumberId;
    public String teaName;
    public String teaSex;
    public String teaInstitution;
    public String teaProfessional;
    public String del;
    public String loginPw;

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaNumberId() {
        return teaNumberId;
    }

    public void setTeaNumberId(String teaNumberId) {
        this.teaNumberId = teaNumberId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaInstitution() {
        return teaInstitution;
    }

    public void setTeaInstitution(String teaInstitution) {
        this.teaInstitution = teaInstitution;
    }

    public String getTeaProfessional() {
        return teaProfessional;
    }

    public void setTeaProfessional(String teaProfessional) {
        this.teaProfessional = teaProfessional;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "teaId='" + teaId + '\'' +
                ", teaNumberId='" + teaNumberId + '\'' +
                ", teaName='" + teaName + '\'' +
                ", teaSex='" + teaSex + '\'' +
                ", teaInstitution='" + teaInstitution + '\'' +
                ", teaProfessional='" + teaProfessional + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}
