package com.ecut.teachingevalutionsystem.orm.mapper;

import com.ecut.teachingevalutionsystem.model.param.UserParam;
import com.ecut.teachingevalutionsystem.orm.entity.StudentEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface LoginMapper {

    boolean teacherLogin(UserParam userParam);

    boolean studentLogin(UserParam userParam);

    boolean adminLogin(UserParam userParam);

    StudentEntity selectStudentByNumberId(String stuNumberId);

    TeacherEntity selectTeacherByNumberId(String teaNumberId);
}
