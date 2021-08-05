package com.springbootWork.manager.teacher;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.table.TeacherGradeItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final ConsumerActivityDAO consumerActivityDAO;

    public GradeManager(ActivityDAO activityDAO, ConsumerActivityDAO consumerActivityDAO) {
        this.activityDAO = activityDAO;
        this.consumerActivityDAO = consumerActivityDAO;
    }

    public Integer getTeacherGradePageCount(Integer teacherId, String activityName, String consumerName) {
        return calcPageCount(
                consumerActivityDAO.countTeacherGrade(teacherId, activityName, consumerName),
                ConsumerActivityDAO.PAGE_SIZE);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String activityName, String consumerName) {
        return consumerActivityDAO.getTeacherGradePage(index, teacherId, activityName, consumerName);
    }

    public ConsumerActivityEntity getConsumerActivityById(Integer consumerActivityId) {
        return consumerActivityDAO.get(consumerActivityId);
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }


    public int updateConsumerActivity(ConsumerActivityEntity entity) {
        return consumerActivityDAO.update(entity);
    }
}
