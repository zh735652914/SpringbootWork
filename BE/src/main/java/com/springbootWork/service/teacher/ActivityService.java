package com.springbootWork.service.teacher;

import com.springbootWork.manager.teacher.ActivityManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.model.vo.response.table.TeacherActivityItemVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_activityService")
public class ActivityService extends BaseService {
    private final ActivityManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public ActivityService(ActivityManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherActivityItemVO> list = manager.listTeacherActivity(teacherId);
        for (TeacherActivityItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
