package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.model.param.Page;
import com.ecut.teachingevalutionsystem.orm.entity.*;
import com.ecut.teachingevalutionsystem.orm.mapper.AdminMapper;
import com.ecut.teachingevalutionsystem.orm.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;

    public List<EvaGradeEntity> selectAllEva(Page page) {
        List<EvaGradeEntity> evaGradeEntityList=studentMapper.selectAllEva(page);
        for (int i=0;i<evaGradeEntityList.size();i++){
            EvaGradeEntity evaGradeEntity1=new EvaGradeEntity();
            evaGradeEntity1.setStuId(page.getSearchId());
            evaGradeEntity1.setCourseId(evaGradeEntityList.get(i).courseId);
            EvaGradeEntity evaGradeEntity=new EvaGradeEntity();
            evaGradeEntity=studentMapper.selectGrade(evaGradeEntity1);
            if(evaGradeEntity!=null){
                if (evaGradeEntity.getEvaGradeCount()!=null && !evaGradeEntity.getEvaGradeCount().equals("")){
                    evaGradeEntityList.get(i).setEvaGradeCount(evaGradeEntity.evaGradeCount);
                }
                if (evaGradeEntity.getMessage()!=null && !evaGradeEntity.getMessage().equals("")){
                    evaGradeEntityList.get(i).setMessage(evaGradeEntity.message);
                }
            }
        }
        return evaGradeEntityList;
    }

    public int getAllEvaCount(Page page) {
        return studentMapper.getAllEvaCount(page);
    }

    public boolean evaGrade(EvaGradeEntity evaGradeEntity) {
        evaGradeEntity.setEvaGradeId(UUID.randomUUID().toString());
        return studentMapper.evaGrade(evaGradeEntity);
    }
    public boolean editStudentPwd(Admin admin) {
        return studentMapper.editStudentPwd(admin);
    }
}
