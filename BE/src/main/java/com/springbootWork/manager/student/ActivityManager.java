package com.springbootWork.manager.student;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.vo.response.table.StudentActivitySelectedItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("student_ActivityManager")
public class ActivityManager extends BaseManager {
    private final StudentActivityDAO studentActivityDAO;
    private final ActivityDAO activityDAO;

    public ActivityManager(StudentActivityDAO studentActivityDAO, ActivityDAO activityDAO) {
        this.studentActivityDAO = studentActivityDAO;
        this.activityDAO = activityDAO;
    }

    public StudentActivityEntity getStudentActivityById(Integer studentActivityId) {
        return studentActivityDAO.get(studentActivityId);
    }

    @Transactional
    public int deleteStudentActivity(StudentActivityEntity studentActivityEntity) {
        activityDAO.decreaseSelectedCount(studentActivityEntity.getActivityId());
        return studentActivityDAO.delete(studentActivityEntity.getId());
    }

    public List<StudentActivitySelectedItemVO> listStudentActivitySelected(Integer studentId) {
        return studentActivityDAO.listStudentActivitySelected(studentId);
    }
}
