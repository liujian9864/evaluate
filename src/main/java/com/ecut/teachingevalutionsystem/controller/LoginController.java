package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.model.param.PageStudent;
import com.ecut.teachingevalutionsystem.model.param.UserParam;
import com.ecut.teachingevalutionsystem.orm.entity.Admin;
import com.ecut.teachingevalutionsystem.orm.entity.StudentEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;
import com.ecut.teachingevalutionsystem.service.LoginService;
import com.ecut.teachingevalutionsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController

public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody UserParam userParam, HttpServletRequest request){
        String userName,type,userId;
        String user=loginService.login(userParam);
        if(user.equals("账号密码错误")){
            return "账号密码错误";
        }
        if (userParam.identity.equals("admin")){
            userId="";
            userName=userParam.userName;
            type="管理员";
        }else if (userParam.identity.equals("student")){
            StudentEntity studentEntity =loginService.selectStudentByNumberId(userParam.userName);
            userId=studentEntity.stuId;
            userName=studentEntity.stuName;
            type="学生";
        }else{
            TeacherEntity teacherEntity =loginService.selectTeacherByNumberId(userParam.userName);
            userId=teacherEntity.teaId;
            userName=teacherEntity.teaName;
            type="教师";
        }
        request.getSession().setAttribute("loginId",userId);
        request.getSession().setAttribute("loginUser",userName);
        request.getSession().setAttribute("loginType",type);
        return user;
    }

    @PostMapping("/loginUser")
    public Admin user(HttpServletRequest request){
        Admin admin=new Admin();
        admin.setUserId((String)request.getSession().getAttribute("loginId"));
        admin.setUserName((String)request.getSession().getAttribute("loginUser"));
        admin.setUserType((String)request.getSession().getAttribute("loginType"));
        return admin;
    }

}
