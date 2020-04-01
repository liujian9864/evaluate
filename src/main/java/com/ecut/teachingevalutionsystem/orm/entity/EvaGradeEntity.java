package com.ecut.teachingevalutionsystem.orm.entity;

public class EvaGradeEntity {
    public String evaGradeId;
    public String courseId;
    public String courseNumberId;
    public String courseName;
    public String courseClass;
    public String courseTeacher;
    public String stuId;
    public String evaGradeCount;
    public String evaGradeAvgCount;
    public String message;

    public String getCourseNumberId() {
        return courseNumberId;
    }

    public void setCourseNumberId(String courseNumberId) {
        this.courseNumberId = courseNumberId;
    }

    public String getEvaGradeId() {
        return evaGradeId;
    }

    public void setEvaGradeId(String evaGradeId) {
        this.evaGradeId = evaGradeId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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

    public String getEvaGradeCount() {
        return evaGradeCount;
    }

    public void setEvaGradeCount(String evaGradeCount) {
        this.evaGradeCount = evaGradeCount;
    }

    public String getEvaGradeAvgCount() {
        return evaGradeAvgCount;
    }

    public void setEvaGradeAvgCount(String evaGradeAvgCount) {
        this.evaGradeAvgCount = evaGradeAvgCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EvaGradeEntity{" +
                "evaGradeId='" + evaGradeId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseClass='" + courseClass + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", stuId='" + stuId + '\'' +
                ", evaGradeCount='" + evaGradeCount + '\'' +
                ", evaGradeAvgCount='" + evaGradeAvgCount + '\'' +
                '}';
    }
}
