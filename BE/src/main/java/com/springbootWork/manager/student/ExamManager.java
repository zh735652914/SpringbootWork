package com.springbootWork.manager.student;

import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final StudentActivityDAO studentActivityDAO;

    public ExamManager(StudentActivityDAO studentActivityDAO) {
        this.studentActivityDAO = studentActivityDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return studentActivityDAO.listStudentExam(studentId);
    }
}
