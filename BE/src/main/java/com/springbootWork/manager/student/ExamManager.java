package com.springbootWork.manager.student;

import com.springbootWork.dao.StudentCourseDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public ExamManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return studentCourseDAO.listStudentExam(studentId);
    }
}
