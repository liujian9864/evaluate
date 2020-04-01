package com.ecut.teachingevalutionsystem.orm.mapper;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.*;

import java.util.List;

public interface StudentMapper {

    List<EvaGradeEntity> selectAllEva(Page page);

    int getAllEvaCount(Page page);

    boolean evaGrade(EvaGradeEntity evaGradeEntity);

    boolean editStudentPwd(Admin admin);

    EvaGradeEntity selectGrade(EvaGradeEntity evaGradeEntity);

}
