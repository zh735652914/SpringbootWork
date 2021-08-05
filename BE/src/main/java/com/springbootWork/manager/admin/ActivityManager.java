package com.springbootWork.manager.admin;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.dao.TeacherDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.bo.ActivityItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.TeacherEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityManager extends BaseManager {
    private final TeacherDAO teacherDAO;
    private final ActivityDAO activityDAO;
    private final StudentActivityDAO studentActivityDAO;

    public ActivityManager(TeacherDAO teacherDAO, ActivityDAO activityDAO, StudentActivityDAO studentActivityDAO) {
        this.teacherDAO = teacherDAO;
        this.activityDAO = activityDAO;
        this.studentActivityDAO = studentActivityDAO;
    }

    public Integer getPageCount(String departmentName, String teacherName, String name) {
        int count = activityDAO.count(departmentName, teacherName, name);
        return calcPageCount(count, ActivityDAO.PAGE_SIZE);
    }

//    public Integer getPageCount(String teacherName, String name) {
//        int count = activityDAO.count(teacherName, name);
//        return calcPageCount(count, ActivityDAO.PAGE_SIZE);
//    }

    public List<ActivityItemBO> getPage(Integer index, String departmentName, String teacherName, String name) {
        return activityDAO.getPage(index, departmentName, teacherName, name);
    }

    public ActivityEntity get(Integer id) {
        return activityDAO.get(id);
    }

    public int create(ActivityEntity entity) {
        return activityDAO.insert(entity);
    }

    public int update(ActivityEntity entity) {
        return activityDAO.update(entity);
    }

    public int delete(Integer id) {
        return activityDAO.delete(id);
    }

    public TeacherEntity getTeacherById(Integer teacherId) {
        return teacherDAO.get(teacherId);
    }

    public boolean hasStudentActivity(Integer activityId) {
        return studentActivityDAO.countByActivityId(activityId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<ActivityEntity> entityList = activityDAO.listName();
        for (ActivityEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
