package com.ecut.teachingevalutionsystem.model.param;

import com.ecut.teachingevalutionsystem.orm.entity.CourseEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public class PageCourse {
    private List<CourseEntity> courses;
    private  int totalPage;
    private  int currentPage;

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
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

    public PageCourse() {
    }

    @Override
    public String toString() {
        return "PageCourse{" +
                "courses=" + courses +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
