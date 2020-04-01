package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.Admin;
import com.ecut.teachingevalutionsystem.orm.entity.EvaGradeEntity;
import com.ecut.teachingevalutionsystem.orm.entity.TeacherEntity;
import com.ecut.teachingevalutionsystem.orm.mapper.StudentMapper;
import com.ecut.teachingevalutionsystem.orm.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    public List<EvaGradeEntity> selectAllEva(Page page) {
//        List<EvaGradeEntity> evaGradeEntityList=new ArrayList<>();
//        List<String> courses=teacherMapper.selectCourseIds(page);
        return teacherMapper.selectAllEva(page);
    }

    public int getAllEvaCount(Page page) {
        return teacherMapper.getAllEvaCount(page);
    }

    public boolean editTeacherPwd(Admin admin) {
        return teacherMapper.editTeacherPwd(admin);
    }
}
