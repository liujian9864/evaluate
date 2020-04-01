package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.model.param.*;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import com.ecut.teachingevalutionsystem.service.AdminService;
import com.ecut.teachingevalutionsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    AdminService adminService;

    @Autowired
    StudentService studentService;
    //查找所有课程
    @PostMapping("/allEva")
    public PageEvaGrade EvaData(int currentPage, String stuId, String courseName){
        Page page=new Page();
        page.setSearchId(stuId);
        page.setSearchName(courseName);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(studentService.getAllEvaCount(page));
        List<EvaGradeEntity> evas= studentService.selectAllEva(page);

        PageEvaGrade pageEvaGrades=new PageEvaGrade();
        pageEvaGrades.setEvas(evas);
        pageEvaGrades.setCurrentPage(currentPage);
        pageEvaGrades.setTotalPage(page.getTotalPage());
        return pageEvaGrades;
    }

    //新增评教信息
    @RequestMapping(value="/evaGrade",method = RequestMethod.POST)
    public boolean addStudent(EvaGradeEntity evaGradeEntity){
        return studentService.evaGrade(evaGradeEntity);
    }

    //修改用户密码
    @RequestMapping(value="/editStudentPwd",method = RequestMethod.POST)
    public boolean editStudentPwd(Admin admin){
        return studentService.editStudentPwd(admin);
    }

}
