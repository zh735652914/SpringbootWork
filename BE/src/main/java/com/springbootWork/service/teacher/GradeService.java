package com.springbootWork.service.teacher;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.teacher.GradeManager;
import com.springbootWork.model.entity.StudentCourseEntity;
import com.springbootWork.model.vo.TeacherGradeVO;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GradeService extends BaseService {
    private final GradeManager manager;
    private final OptionManager optionManager;

    public GradeService(GradeManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO getPageCount(String courseName, String studentName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePageCount(teacherId, courseName, studentName));
    }

    public ResultVO getPage(Integer index, String courseName, String studentName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePage(index, teacherId, courseName, studentName));
    }

    public ResultVO update(TeacherGradeVO vo) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        StudentCourseEntity studentCourse = manager.getStudentCourseById(vo.getStudentCourseId());
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + vo.getStudentCourseId() + "不存在");
        }
        if (!manager.getCourseById(studentCourse.getCourseId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        BeanUtils.copyProperties(vo, studentCourse);

        manager.updateStudentCourse(studentCourse);
        return result("打分成功");
    }

    public ResultVO get(Integer studentCourseId) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        StudentCourseEntity studentCourse = manager.getStudentCourseById(studentCourseId);
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + studentCourseId + "不存在");
        }
        if (!manager.getCourseById(studentCourse.getCourseId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        TeacherGradeVO vo = new TeacherGradeVO();
        BeanUtils.copyProperties(studentCourse, vo);
        vo.setStudentCourseId(studentCourseId);

        return result(vo);
    }
}
