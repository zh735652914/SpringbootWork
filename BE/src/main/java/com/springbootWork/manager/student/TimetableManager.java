package com.springbootWork.manager.student;

import com.springbootWork.dao.StudentActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student_timetableManager")
public class TimetableManager extends BaseManager {
    private final StudentActivityDAO studentActivityDAO;

    public TimetableManager(StudentActivityDAO studentActivityDAO) {
        this.studentActivityDAO = studentActivityDAO;
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return studentActivityDAO.listStudentTimetable(studentId);
    }
}
