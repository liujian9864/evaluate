package com.ecut.teachingevalutionsystem.orm.mapper;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface AdminMapper {

    List<StudentEntity> selectAllStudent(Page page);

    List<TeacherEntity> selectAllTeacher(Page page);

    List<TeacherEntity> findAllTeacher();

    List<CourseEntity> selectAllCourse(Page page);

    List<EvaGradeEntity> selectAllEva(Page page);

    List<String> selectEvaGradeCount(CourseEntity courseEntity);

    int getAllCount(Page page);

    int getAllTeacherCount(Page page);

    int getAllCourseCount(Page page);

    int getAllEvaCount(Page page);

    void deleteStudentById(String stuId);

    void deleteTeacherById(String teaId);

    void deleteCourseById(String courseId);

    StudentEntity selectStudentById(String stuId);

    TeacherEntity selectTeacherById(String teaId);

    CourseEntity selectCourseById(String courseId);

    boolean updateStudent(StudentEntity studentEntity);

    boolean updateTeacher(TeacherEntity teacherEntity);

    boolean updateCourse(CourseEntity courseEntity);

    boolean addStudent(StudentEntity studentEntity);

    boolean addTeacher(TeacherEntity teacherEntity);

    boolean addCourse(CourseEntity courseEntity);

    boolean editAdminPwd(Admin admin);

}
