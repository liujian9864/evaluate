package com.ecut.teachingevalutionsystem.orm.mapper;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.Admin;
import com.ecut.teachingevalutionsystem.orm.entity.EvaGradeEntity;

import java.util.List;

public interface TeacherMapper {

    List<EvaGradeEntity> selectAllEva(Page page);

    int getAllEvaCount(Page page);

    boolean editTeacherPwd(Admin admin);

    List<String> selectCourseIds(Page page);

}
