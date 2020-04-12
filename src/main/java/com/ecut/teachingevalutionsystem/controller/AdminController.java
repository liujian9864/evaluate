package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.model.param.*;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import com.ecut.teachingevalutionsystem.service.AdminService;
import com.ecut.teachingevalutionsystem.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    //查找所有学生
    @PostMapping("/allstudent")
    public PageStudent studentData( int currentPage,String stuNumberId,String stuName,String stuInstitution,String stuClass){
        Page page=new Page();
        page.setSearchId(stuNumberId);
        page.setSearchName(stuName);
        page.setSearchInstitution(stuInstitution);
        page.setSearchClass(stuClass);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(adminService.getAllCount(page));
        List<StudentEntity> students= adminService.selectAllStudent(page);

        PageStudent pageStudent=new PageStudent();
        pageStudent.setStudents(students);
        pageStudent.setCurrentPage(currentPage);
        pageStudent.setTotalPage(page.getTotalPage());
        return pageStudent;
    }
    //根据id删除学生
    @RequestMapping(value="/deleteStudentById",method = RequestMethod.POST)
    public void deleteStudentById(String stuId){
        adminService.deleteStudentById(stuId);
    }
    //根据id查找学生
    @RequestMapping(value="/selectStudentById",method = RequestMethod.POST)
    public StudentEntity selectStudentById(String stuId){
       return adminService.selectStudentById(stuId);
    }
    //修改学生信息
    @RequestMapping(value="/updateStudent",method = RequestMethod.POST)
    public boolean updateStudent(StudentEntity studentEntity){
        return adminService.updateStudent(studentEntity);
    }

    //新增学生信息
    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    public boolean addStudent(StudentEntity studentEntity){
        return adminService.addStudent(studentEntity);
    }

    //修改用户密码
    @RequestMapping(value="/editAdminPwd",method = RequestMethod.POST)
    public boolean editAdminPwd(Admin admin){
        return adminService.editAdminPwd(admin);
    }

    //查找所有教师
    @PostMapping("/allteacher")
    public PageTeacher teacherData( int currentPage,String teaNumberId,String teaName,String teaInstitution,String teaProfessional){
        Page page=new Page();
        page.setSearchId(teaNumberId);
        page.setSearchName(teaName);
        page.setSearchInstitution(teaInstitution);
        page.setSearchClass(teaProfessional);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(adminService.getAllTeacherCount(page));
        List<TeacherEntity> teachers= adminService.selectAllTeacher(page);

        PageTeacher pageTeacher=new PageTeacher();
        pageTeacher.setTeachers(teachers);
        pageTeacher.setCurrentPage(currentPage);
        pageTeacher.setTotalPage(page.getTotalPage());
        return pageTeacher;
    }
    //查找所有教师
    @GetMapping("/findAllTeacher")
    public JsonResult<List<TeacherEntity>> findAllTeacher(){

        List<TeacherEntity> teachers= adminService.findAllTeacher();
        return new JsonResult<>(2000,teachers);
    }

    //根据id删除老师
    @RequestMapping(value="/deleteTeacherById",method = RequestMethod.POST)
    public void deleteTeacherById(String teaId){
        adminService.deleteTeacherById(teaId);
    }

    //根据id查找老师
    @RequestMapping(value="/selectTeacherById",method = RequestMethod.POST)
    public TeacherEntity selectTeacherById(String teaId){
        return adminService.selectTeacherById(teaId);
    }

    //修改教师信息
    @RequestMapping(value="/updateTeacher",method = RequestMethod.POST)
    public boolean updateTeacher(TeacherEntity teacherEntity){
        return adminService.updateTeacher(teacherEntity);
    }

    //新增教师信息
    @RequestMapping(value="/addTeacher",method = RequestMethod.POST)
    public boolean addTeacher(TeacherEntity teacherEntity){
        return adminService.addTeacher(teacherEntity);
    }

    //查找所有课程
    @PostMapping("/allCourse")
    public PageCourse CourseData(int currentPage, String courseNumberId, String courseName, String courseClass, String courseTeacher){
        Page page=new Page();
        page.setSearchId(courseNumberId);
        page.setSearchName(courseName);
        page.setSearchInstitution(courseClass);
        page.setSearchClass(courseTeacher);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(adminService.getAllCourseCount(page));
        List<CourseEntity> courses= adminService.selectAllCourse(page);

        PageCourse pageCourse=new PageCourse();
        pageCourse.setCourses(courses);
        pageCourse.setCurrentPage(currentPage);
        pageCourse.setTotalPage(page.getTotalPage());
        return pageCourse;
    }

    //根据id删除课程
    @RequestMapping(value="/deleteCourseById",method = RequestMethod.POST)
    public void deleteCourseById(String courseId){
        adminService.deleteCourseById(courseId);
    }

    //根据id查找课程
    @RequestMapping(value="/selectCourseById",method = RequestMethod.POST)
    public CourseEntity selectCourseById(String courseId){
        return adminService.selectCourseById(courseId);
    }

    //修改课程信息
    @RequestMapping(value="/updateCourse",method = RequestMethod.POST)
    public boolean updateCourse(CourseEntity courseEntity){
        return adminService.updateCourse(courseEntity);
    }

    //新增课程信息
    @RequestMapping(value="/addCourse",method = RequestMethod.POST)
    public boolean addCourse(CourseEntity courseEntity){
        return adminService.addCourse(courseEntity);
    }

    //查找所有课程
    @PostMapping("/allEva")
    public PageEvaGrade EvaData(int currentPage, String courseNumberId, String courseName, String courseClass, String courseTeacher){
        Page page=new Page();
        page.setSearchId(courseNumberId);
        page.setSearchName(courseName);
        page.setSearchInstitution(courseClass);
        page.setSearchClass(courseTeacher);
        page.setCurrentPage(currentPage);
        page.setPageSize(8);
        page.setTotalCount(adminService.getAllEvaCount(page));
        List<EvaGradeEntity> evas= adminService.selectAllEva(page);

        PageEvaGrade pageEvaGrades=new PageEvaGrade();
        pageEvaGrades.setEvas(evas);
        pageEvaGrades.setCurrentPage(currentPage);
        pageEvaGrades.setTotalPage(page.getTotalPage());
        return pageEvaGrades;
    }
}
