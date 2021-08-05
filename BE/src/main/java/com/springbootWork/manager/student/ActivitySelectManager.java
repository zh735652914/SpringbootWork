package com.springbootWork.manager.student;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.dao.StudentDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.bo.StudentActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ActivitySelectManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final StudentDAO studentDAO;
    private final StudentActivityDAO studentActivityDAO;

    public ActivitySelectManager(ActivityDAO activityDAO, StudentDAO studentDAO, StudentActivityDAO studentActivityDAO) {
        this.activityDAO = activityDAO;
        this.studentDAO = studentDAO;
        this.studentActivityDAO = studentActivityDAO;
    }

    public Integer getPageCount(Integer studentId, String activityName, String teacherName) {
        Integer departmentId = studentDAO.getDepartmentIdById(studentId);
        Integer grade = studentDAO.getGradeById(studentId);
        return calcPageCount(activityDAO.countStudentCanSelect(departmentId, studentId, grade, activityName, teacherName), StudentActivityDAO.PAGE_SIZE);
    }

    public List<StudentActivitySelectItemBO> getPage(Integer index, Integer studentId, String activityName, String teacherName) {
        Integer departmentId = studentDAO.getDepartmentIdById(studentId);
        Integer grade = studentDAO.getGradeById(studentId);
        return activityDAO.getStudentCanSelectPage(index, departmentId, studentId, grade, activityName, teacherName);
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

//    public boolean inSameDepartment(Integer activityId, Integer studentId) {
//        return activityDAO.getDepartmentIdById(activityId)
//                .equals(studentDAO.getDepartmentIdById(studentId));
//    }

    public StudentActivityEntity getStudentActivityByActivityIdAndStudentId(Integer activityId, Integer studentId) {
        return studentActivityDAO.getByActivityIdAndStudentId(activityId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return studentDAO.getGradeById(studentId);
    }

    @Transactional
    public int create(StudentActivityEntity entity) {
        activityDAO.increaseSelectedCount(entity.getActivityId());
        return studentActivityDAO.insert(entity);
    }

    public int countStudentActivitySelectedByTimePart(Integer studentId, String timePart) {
        return studentActivityDAO.countStudentActivitySelectedByTimePart(studentId, timePart);
    }
}
