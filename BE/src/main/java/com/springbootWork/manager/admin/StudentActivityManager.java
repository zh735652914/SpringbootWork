package com.springbootWork.manager.admin;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.dao.StudentDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.entity.StudentEntity;
import com.springbootWork.model.vo.response.table.StudentActivityItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentActivityManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final StudentActivityDAO studentActivityDAO;
    private final StudentDAO studentDAO;

    public StudentActivityManager(ActivityDAO activityDAO, StudentActivityDAO studentActivityDAO, StudentDAO studentDAO) {
        this.activityDAO = activityDAO;
        this.studentActivityDAO = studentActivityDAO;
        this.studentDAO = studentDAO;
    }

    public Integer getPageCount(String className, String activityName, String studentName) {
        int count = studentActivityDAO.count(className, activityName, studentName);
        return calcPageCount(count, StudentActivityDAO.PAGE_SIZE);
    }

    public List<StudentActivityItemVO> getPage(Integer index, String className, String activityName, String studentName) {
        return studentActivityDAO.getPage(index, className, activityName, studentName);
    }

    public StudentActivityEntity get(Integer id) {
        return studentActivityDAO.get(id);
    }

    @Transactional
    public int create(StudentActivityEntity entity) {
        activityDAO.increaseSelectedCount(entity.getActivityId());
        return studentActivityDAO.insert(entity);
    }

    public int update(StudentActivityEntity entity) {
        return studentActivityDAO.update(entity);
    }

    @Transactional
    public int delete(StudentActivityEntity entity) {
        activityDAO.decreaseSelectedCount(entity.getActivityId());
        return studentActivityDAO.delete(entity.getId());
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public StudentActivityEntity getByActivityIdAndStudentId(Integer activityId, Integer studentId) {
        return studentActivityDAO.getByActivityIdAndStudentId(activityId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return studentDAO.getGradeById(studentId);
    }

//    public boolean inSameDepartment(Integer activityId, Integer studentId) {
//        return activityDAO.getDepartmentIdById(activityId)
//                .equals(studentDAO.getDepartmentIdById(studentId));
//    }
}
