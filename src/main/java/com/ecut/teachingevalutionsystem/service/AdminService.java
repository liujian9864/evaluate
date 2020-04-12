package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import com.ecut.teachingevalutionsystem.orm.mapper.AdminMapper;
import com.ecut.teachingevalutionsystem.orm.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    @Resource
    DistrictMapper districtMapper;

    public List<StudentEntity> selectAllStudent(Page page) {
        return adminMapper.selectAllStudent(page);
    }

    public List<TeacherEntity> selectAllTeacher(Page page) {
        return adminMapper.selectAllTeacher(page);
    }
    public List<TeacherEntity> findAllTeacher() {
        return adminMapper.findAllTeacher();
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
        StudentEntity studentEntity=adminMapper.selectStudentById(stuId);
        studentEntity.setStuInstitution(districtMapper.findByName(studentEntity.getStuInstitution()).getCode());
        return studentEntity;
    }

    public TeacherEntity selectTeacherById(String teaId) {
        return adminMapper.selectTeacherById(teaId);
    }

    public CourseEntity selectCourseById(String courseId) {
        CourseEntity courseEntity=adminMapper.selectCourseById(courseId);
        courseEntity.setCourseName(districtMapper.findByName(courseEntity.getCourseName()).getCode());
        return courseEntity;
    }

    public boolean updateStudent(StudentEntity studentEntity) {
        studentEntity.setStuInstitution(districtMapper.findByCode(studentEntity.getStuInstitution()).getName());
        return adminMapper.updateStudent(studentEntity);
    }

    public boolean updateTeacher(TeacherEntity teacherEntity) {
        return adminMapper.updateTeacher(teacherEntity);
    }

    public boolean updateCourse(CourseEntity courseEntity) {
        courseEntity.setCourseName(districtMapper.findByCode(courseEntity.getCourseName()).getName());
        return adminMapper.updateCourse(courseEntity);
    }

    public boolean addStudent(StudentEntity studentEntity) {
        studentEntity.setStuId(UUID.randomUUID().toString());
        studentEntity.setStuInstitution(districtMapper.findByCode(studentEntity.getStuInstitution()).getName());
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
        courseEntity.setCourseName(districtMapper.findByCode(courseEntity.getCourseName()).getName());
        return adminMapper.addCourse(courseEntity);
    }

    public boolean editAdminPwd(Admin admin) {
        return adminMapper.editAdminPwd(admin);
    }
}
