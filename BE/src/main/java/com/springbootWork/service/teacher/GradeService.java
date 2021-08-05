package com.springbootWork.service.teacher;

import com.springbootWork.manager.OptionManager;
import com.springbootWork.manager.teacher.GradeManager;
import com.springbootWork.model.entity.ConsumerActivityEntity;
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

    public ResultVO getPageCount(String activityName, String consumerName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePageCount(teacherId, activityName, consumerName));
    }

    public ResultVO getPage(Integer index, String activityName, String consumerName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePage(index, teacherId, activityName, consumerName));
    }

    public ResultVO update(TeacherGradeVO vo) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        ConsumerActivityEntity consumerActivity = manager.getConsumerActivityById(vo.getConsumerActivityId());
        if (consumerActivity == null) {
            return failedResult("用户选课Id:" + vo.getConsumerActivityId() + "不存在");
        }
        if (!manager.getActivityById(consumerActivity.getActivityId()).getTeacherId().equals(teacherId)) {
            return failedResult("此活动非您教授");
        }

        BeanUtils.copyProperties(vo, consumerActivity);

        manager.updateConsumerActivity(consumerActivity);
        return result("打分成功");
    }

    public ResultVO get(Integer consumerActivityId) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        ConsumerActivityEntity consumerActivity = manager.getConsumerActivityById(consumerActivityId);
        if (consumerActivity == null) {
            return failedResult("用户选课Id:" + consumerActivityId + "不存在");
        }
        if (!manager.getActivityById(consumerActivity.getActivityId()).getTeacherId().equals(teacherId)) {
            return failedResult("此活动非您教授");
        }

        TeacherGradeVO vo = new TeacherGradeVO();
        BeanUtils.copyProperties(consumerActivity, vo);
        vo.setConsumerActivityId(consumerActivityId);

        return result(vo);
    }
}
