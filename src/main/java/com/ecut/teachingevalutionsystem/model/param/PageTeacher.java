package com.ecut.teachingevalutionsystem.model.param;

import com.ecut.teachingevalutionsystem.orm.entity.StudentEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public class PageTeacher {
    private List<TeacherEntity> teachers;
    private  int totalPage;
    private  int currentPage;

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public PageTeacher() {
    }

    @Override
    public String toString() {
        return "PageLaw{" +
                "laws=" + teachers +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
