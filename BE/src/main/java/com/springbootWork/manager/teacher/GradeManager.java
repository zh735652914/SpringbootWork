package com.springbootWork.manager.teacher;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.table.TeacherGradeItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final StudentActivityDAO studentActivityDAO;

    public GradeManager(ActivityDAO activityDAO, StudentActivityDAO studentActivityDAO) {
        this.activityDAO = activityDAO;
        this.studentActivityDAO = studentActivityDAO;
    }

    public Integer getTeacherGradePageCount(Integer teacherId, String activityName, String studentName) {
        return calcPageCount(
                studentActivityDAO.countTeacherGrade(teacherId, activityName, studentName),
                StudentActivityDAO.PAGE_SIZE);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String activityName, String studentName) {
        return studentActivityDAO.getTeacherGradePage(index, teacherId, activityName, studentName);
    }

    public StudentActivityEntity getStudentActivityById(Integer studentActivityId) {
        return studentActivityDAO.get(studentActivityId);
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }


    public int updateStudentActivity(StudentActivityEntity entity) {
        return studentActivityDAO.update(entity);
    }
}
