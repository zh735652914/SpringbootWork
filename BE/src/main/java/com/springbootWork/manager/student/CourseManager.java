package com.springbootWork.manager.student;

import com.springbootWork.dao.CourseDAO;
import com.springbootWork.dao.StudentCourseDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.StudentCourseEntity;
import com.springbootWork.model.vo.response.table.StudentCourseSelectedItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("student_CourseManager")
public class CourseManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;
    private final CourseDAO courseDAO;

    public CourseManager(StudentCourseDAO studentCourseDAO, CourseDAO courseDAO) {
        this.studentCourseDAO = studentCourseDAO;
        this.courseDAO = courseDAO;
    }

    public StudentCourseEntity getStudentCourseById(Integer studentCourseId) {
        return studentCourseDAO.get(studentCourseId);
    }

    @Transactional
    public int deleteStudentCourse(StudentCourseEntity studentCourseEntity) {
        courseDAO.decreaseSelectedCount(studentCourseEntity.getCourseId());
        return studentCourseDAO.delete(studentCourseEntity.getId());
    }

    public List<StudentCourseSelectedItemVO> listStudentCourseSelected(Integer studentId) {
        return studentCourseDAO.listStudentCourseSelected(studentId);
    }
}
