package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import com.ecut.teachingevalutionsystem.orm.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    public List<StudentEntity> selectAllStudent(Page page) {
        return adminMapper.selectAllStudent(page);
    }

    public List<TeacherEntity> selectAllTeacher(Page page) {
        return adminMapper.selectAllTeacher(page);
    }

    public List<EvaGradeEntity> selectAllEva(Page page) {
        List<EvaGradeEntity> evaGradeEntityList=adminMapper.selectAllEva(page);
        for (int i=0;i<evaGradeEntityList.size();i++){
            CourseEntity courseEntity=adminMapper.selectCourseById(evaGradeEntityList.get(i).courseId);
            List<String> evaGradeCount=adminMapper.selectEvaGradeCount(courseEntity);
            int size=evaGradeCount.size();
            int count=0;
            String avgCount;
            for (int j=0;j<size;j++){
                count+=Integer.parseInt(evaGradeCount.get(j));
            }
            if(size==0){
                evaGradeEntityList.remove(i);
                i=i-1;
                continue;
            }else{
                avgCount=String.valueOf((int)(count/size));
            }
            evaGradeEntityList.get(i).setCourseTeacher(courseEntity.courseTeacher);
            evaGradeEntityList.get(i).setCourseNumberId(courseEntity.courseNumberId);
            evaGradeEntityList.get(i).setCourseName(courseEntity.courseName);
            evaGradeEntityList.get(i).setCourseClass(courseEntity.courseClass);
            evaGradeEntityList.get(i).setEvaGradeAvgCount(avgCount);
        }
        return evaGradeEntityList;
    }

    public List<CourseEntity> selectAllCourse(Page page) {
        return adminMapper.selectAllCourse(page);
    }

    public int getAllCount(Page page) {
        return adminMapper.getAllCount(page);
    }

    public int getAllTeacherCount(Page page) {
        return adminMapper.getAllTeacherCount(page);
    }

    public int getAllCourseCount(Page page) {
        return adminMapper.getAllCourseCount(page);
    }

    public int getAllEvaCount(Page page) {
        return adminMapper.getAllEvaCount(page);
    }

    public void deleteStudentById(String stuId) {
        adminMapper.deleteStudentById(stuId);
    }

    public void deleteTeacherById(String teaId) {
        adminMapper.deleteTeacherById(teaId);
    }

    public void deleteCourseById(String courseId) {
        adminMapper.deleteCourseById(courseId);
    }

    public StudentEntity selectStudentById(String stuId) {
        return adminMapper.selectStudentById(stuId);
    }

    public TeacherEntity selectTeacherById(String teaId) {
        return adminMapper.selectTeacherById(teaId);
    }

    public CourseEntity selectCourseById(String courseId) {
        return adminMapper.selectCourseById(courseId);
    }

    public boolean updateStudent(StudentEntity studentEntity) {
        return adminMapper.updateStudent(studentEntity);
    }

    public boolean updateTeacher(TeacherEntity teacherEntity) {
        return adminMapper.updateTeacher(teacherEntity);
    }

    public boolean updateCourse(CourseEntity courseEntity) {
        return adminMapper.updateCourse(courseEntity);
    }

    public boolean addStudent(StudentEntity studentEntity) {
        studentEntity.setStuId(UUID.randomUUID().toString());
        studentEntity.setLoginPw(studentEntity.stuNumberId);
        return adminMapper.addStudent(studentEntity);
    }

    public boolean addTeacher(TeacherEntity teacherEntity) {
        teacherEntity.setTeaId(UUID.randomUUID().toString());
        teacherEntity.setLoginPw(teacherEntity.teaNumberId);
        return adminMapper.addTeacher(teacherEntity);
    }

    public boolean addCourse(CourseEntity courseEntity) {
        courseEntity.setCourseId(UUID.randomUUID().toString());
        return adminMapper.addCourse(courseEntity);
    }

    public boolean editAdminPwd(Admin admin) {
        return adminMapper.editAdminPwd(admin);
    }
}
