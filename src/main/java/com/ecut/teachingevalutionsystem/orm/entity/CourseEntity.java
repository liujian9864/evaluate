package com.ecut.teachingevalutionsystem.orm.entity;

public class CourseEntity {
    public String courseId;
    public String courseNumberId;
    public String courseName;
    public String courseClass;
    public String courseTeacher;
    public String courseEvaluate;
    public String del;

    public String getCourseNumberId() {
        return courseNumberId;
    }

    public void setCourseNumberId(String courseNumberId) {
        this.courseNumberId = courseNumberId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseEvaluate() {
        return courseEvaluate;
    }

    public void setCourseEvaluate(String courseEvaluate) {
        this.courseEvaluate = courseEvaluate;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseClass='" + courseClass + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseEvaluate='" + courseEvaluate + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}
