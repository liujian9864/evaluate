package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping("index")
    public String index(){
        return "login";
    }

    @GetMapping("adminIndex")
    public String adminIndex(){
        return "adminIndex";
    }

    @GetMapping("studentIndex")
    public String studentIndex(){
        return "studentIndex";
    }

    @GetMapping("teacherIndex")
    public String teacherIndex(){
        return "teacherIndex";
    }
}
