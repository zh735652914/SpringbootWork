package com.springbootWork.service.teacher;

import com.springbootWork.manager.teacher.CourseManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.model.vo.response.table.TeacherCourseItemVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
