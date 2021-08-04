package com.springbootWork.manager.teacher;

import com.springbootWork.dao.TeacherDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TimetableManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return teacherDAO.listTeacherTimetable(teacherId);
    }
}
