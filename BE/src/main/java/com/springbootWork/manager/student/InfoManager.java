package com.springbootWork.manager.student;

import com.springbootWork.dao.StudentDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.StudentEntity;
import com.springbootWork.model.vo.response.StudentInfoVO;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
