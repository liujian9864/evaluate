package com.ecut.teachingevalutionsystem.model.param;

import com.ecut.teachingevalutionsystem.orm.entity.CourseEntity;
import com.ecut.teachingevalutionsystem.orm.entity.EvaGradeEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public class PageEvaGrade {
    private List<EvaGradeEntity> evas;
    private  int totalPage;
    private  int currentPage;

    public List<EvaGradeEntity> getEvas() {
        return evas;
    }

    public void setEvas(List<EvaGradeEntity> evas) {
        this.evas = evas;
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

    public PageEvaGrade() {
    }

    @Override
    public String toString() {
        return "PageCourse{" +
                "evas=" + evas +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
