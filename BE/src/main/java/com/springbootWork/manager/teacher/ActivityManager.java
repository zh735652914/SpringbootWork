package com.springbootWork.manager.teacher;

import com.springbootWork.dao.TeacherDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.TeacherActivityItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_ActivityManager")
public class ActivityManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public ActivityManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TeacherActivityItemVO> listTeacherActivity(Integer teacherId) {
        return teacherDAO.listTeacherActivity(teacherId);
    }
}
