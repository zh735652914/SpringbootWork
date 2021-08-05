package com.springbootWork.service.student;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.student.ActivitySelectManager;
import com.springbootWork.model.bo.StudentActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.StudentActivityEntity;
import com.springbootWork.model.entity.StudentEntity;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.model.vo.response.table.StudentActivitySelectItemVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.util.LessonTimeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitySelectService extends BaseService {
    private final ActivitySelectManager manager;
    private final OptionManager optionManager;
    private final LessonTimeConverter lessonTimeConverter;

    public ActivitySelectService(ActivitySelectManager manager, OptionManager optionManager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.optionManager = optionManager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(String activityName, String teacherName) {
        Integer studentId = getUserId();
        return result(manager.getPageCount(studentId, activityName, teacherName));
    }

    public ResultVO getPage(Integer index, String activityName, String teacherName) {
        Integer studentId = getUserId();

        List<StudentActivitySelectItemBO> boList = manager.getPage(index, studentId, activityName, teacherName);
        List<StudentActivitySelectItemVO> voList = new ArrayList<>(boList.size());

        for (StudentActivitySelectItemBO bo : boList) {
            StudentActivitySelectItemVO vo = new StudentActivitySelectItemVO();
            BeanUtils.copyProperties(bo, vo);
            vo.setTime(lessonTimeConverter.covertTimePart(bo.getTime()));
            voList.add(vo);
        }

        return result(voList);
    }

    public ResultVO create(Integer activityId) {
        Integer studentId = getUserId();

        if (!optionManager.getAllowStudentSelect()) {
            return failedResult("现在不是选课时间!");
        }
        StudentEntity student = manager.getStudentById(studentId);
        ActivityEntity activity = manager.getActivityById(activityId);
        if (student == null) {
            return failedResult("学生Id:" + studentId + "不存在!");
        }
        if (activity == null) {
            return failedResult("课程Id:" + activityId + "不存在!");
        }
//        if (!manager.inSameDepartment(activityId, studentId)) {
//            return failedResult("学生不能选择非教学系的课程!");
//        }
        if (activity.getSelectedCount() >= activity.getMaxSize()) {
            return failedResult("课容量已满!");
        }
        if (manager.getStudentActivityByActivityIdAndStudentId(activityId, studentId) != null) {
            return failedResult("学生已选修此课程!");
        }
//        if (!manager.getStudentGradeById(student.getId()).equals(activity.getGrade())) {
//            return failedResult("学生与课程不在同一年级");
//        }
        String timePart = splitTimePart(activity.getTime());
        if (manager.countStudentActivitySelectedByTimePart(studentId, timePart) > 0) {
            return failedResult("上课时间冲突!");
        }

        StudentActivityEntity studentActivity = new StudentActivityEntity();
        studentActivity.setActivityId(activityId);
        studentActivity.setStudentId(studentId);
        manager.create(studentActivity);

        return result("选课成功");
    }

    private String splitTimePart(String time) {
        String[] spilt = time.split("-");
        return spilt[0] + "-" + spilt[1];
    }
}
