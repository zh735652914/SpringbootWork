package com.springbootWork.manager.teacher;

import com.springbootWork.dao.CourseDAO;
import com.springbootWork.dao.StudentCourseDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.CourseEntity;
import com.springbootWork.model.entity.StudentCourseEntity;
import com.springbootWork.model.vo.response.table.TeacherGradeItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeManager extends BaseManager {
    private final CourseDAO courseDAO;
    private final StudentCourseDAO studentCourseDAO;

    public GradeManager(CourseDAO courseDAO, StudentCourseDAO studentCourseDAO) {
        this.courseDAO = courseDAO;
        this.studentCourseDAO = studentCourseDAO;
    }

    public Integer getTeacherGradePageCount(Integer teacherId, String courseName, String studentName) {
        return calcPageCount(
                studentCourseDAO.countTeacherGrade(teacherId, courseName, studentName),
                StudentCourseDAO.PAGE_SIZE);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String courseName, String studentName) {
        return studentCourseDAO.getTeacherGradePage(index, teacherId, courseName, studentName);
    }

    public StudentCourseEntity getStudentCourseById(Integer studentCourseId) {
        return studentCourseDAO.get(studentCourseId);
    }

    public CourseEntity getCourseById(Integer courseId) {
        return courseDAO.get(courseId);
    }


    public int updateStudentCourse(StudentCourseEntity entity) {
        return studentCourseDAO.update(entity);
    }
}
