package com.ecut.teachingevalutionsystem.model.param;

import com.ecut.teachingevalutionsystem.orm.entity.StudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public class PageStudent {
    private List<StudentEntity> students;
    private  int totalPage;
    private  int currentPage;

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
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

    public PageStudent() {
    }

    @Override
    public String toString() {
        return "PageLaw{" +
                "laws=" + students +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
