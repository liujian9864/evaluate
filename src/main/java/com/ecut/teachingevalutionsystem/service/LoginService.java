package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.model.param.UserParam;
import com.ecut.teachingevalutionsystem.orm.entity.StudentEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;
import com.ecut.teachingevalutionsystem.orm.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    public String login(UserParam userParam){
        if(userParam.identity.equals("admin")){
            boolean l=loginMapper.adminLogin(userParam);
            if(l){
                return "adminIndex";
            }
        }else if (userParam.identity.equals("teacher")){
            boolean l=loginMapper.teacherLogin(userParam);
            if(l) {
                return "teacherIndex";
            }
        }else if (userParam.identity.equals("student")){
            boolean l=loginMapper.studentLogin(userParam);
            if(l) {
                return "studentIndex";
            }
        }else{
            return "账号密码错误";
        }
        return "账号密码错误";
    }

    public StudentEntity selectStudentByNumberId(String stuNumberId) {
        return loginMapper.selectStudentByNumberId(stuNumberId);
    }

    public TeacherEntity selectTeacherByNumberId(String teaNumberId) {
        return loginMapper.selectTeacherByNumberId(teaNumberId);
    }
}
