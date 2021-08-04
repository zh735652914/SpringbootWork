package com.springbootWork.service.student;

import com.springbootWork.manager.student.TimetableManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
