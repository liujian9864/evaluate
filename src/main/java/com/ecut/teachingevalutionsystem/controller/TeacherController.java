package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.model.param.PageEvaGrade;
import com.ecut.teachingevalutionsystem.orm.entity.Admin;
import com.ecut.teachingevalutionsystem.orm.entity.EvaGradeEntity;
import com.ecut.teachingevalutionsystem.service.AdminService;
import com.ecut.teachingevalutionsystem.service.StudentService;
import com.ecut.teachingevalutionsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //查找所有课程
    @PostMapping("/allEva")
    public PageEvaGrade EvaData(int currentPage, String teaId, String courseName){
        Page page=new Page();
        page.setSearchId(teaId);
        page.setSearchName(courseName);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(teacherService.getAllEvaCount(page));
        List<EvaGradeEntity> evas= teacherService.selectAllEva(page);

        PageEvaGrade pageEvaGrades=new PageEvaGrade();
        pageEvaGrades.setEvas(evas);
        pageEvaGrades.setCurrentPage(currentPage);
        pageEvaGrades.setTotalPage(page.getTotalPage());
        return pageEvaGrades;
    }

    //修改用户密码
    @RequestMapping(value="/editTeacherPwd",method = RequestMethod.POST)
    public boolean editTeacherPwd(Admin admin){
        return teacherService.editTeacherPwd(admin);
    }

}
