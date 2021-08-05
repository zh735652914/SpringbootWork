package com.springbootWork.manager.admin;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.TeacherDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.TeacherEntity;
import com.springbootWork.model.vo.response.IdNameVO;
import com.springbootWork.model.vo.response.table.TeacherItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherManager extends BaseManager {
    private final TeacherDAO teacherDAO;
    private final ActivityDAO activityDAO;

    public TeacherManager(TeacherDAO teacherDAO, ActivityDAO activityDAO) {
        this.teacherDAO = teacherDAO;
        this.activityDAO = activityDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = teacherDAO.count(departmentName, name);
        return calcPageCount(count, TeacherDAO.PAGE_SIZE);
    }

    public List<TeacherItemVO> getPage(Integer index, String departmentName, String name) {
        return teacherDAO.getPage(index, departmentName, name);
    }

    public TeacherEntity get(Integer id) {
        return teacherDAO.get(id);
    }

    public int create(TeacherEntity entity) {
        return teacherDAO.insert(entity);
    }

    public int update(TeacherEntity entity) {
        return teacherDAO.update(entity);
    }

    public int delete(Integer id) {
        return teacherDAO.delete(id);
    }

    public boolean hasActivity(Integer teacherId) {
        return activityDAO.countByTeacherId(teacherId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<TeacherEntity> entityList = teacherDAO.listName();
        for (TeacherEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
