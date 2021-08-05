package com.springbootWork.manager.consumer;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ActivitySelectManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final ConsumerDAO consumerDAO;
    private final ConsumerActivityDAO consumerActivityDAO;

    public ActivitySelectManager(ActivityDAO activityDAO, ConsumerDAO consumerDAO, ConsumerActivityDAO consumerActivityDAO) {
        this.activityDAO = activityDAO;
        this.consumerDAO = consumerDAO;
        this.consumerActivityDAO = consumerActivityDAO;
    }

    public Integer getPageCount(Integer consumerId, String activityName, String teacherName) {
        Integer grade = consumerDAO.getGradeById(consumerId);
        return calcPageCount(activityDAO.countConsumerCanSelect(consumerId, grade, activityName, teacherName), ConsumerActivityDAO.PAGE_SIZE);
    }

    public List<ConsumerActivitySelectItemBO> getPage(Integer index, Integer consumerId, String activityName, String teacherName) {
        Integer grade = consumerDAO.getGradeById(consumerId);
        return activityDAO.getConsumerCanSelectPage(index, consumerId, grade, activityName, teacherName);
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }

    public ConsumerEntity getConsumerById(Integer consumerId) {
        return consumerDAO.get(consumerId);
    }

    public ConsumerActivityEntity getConsumerActivityByActivityIdAndConsumerId(Integer activityId, Integer consumerId) {
        return consumerActivityDAO.getByActivityIdAndConsumerId(activityId, consumerId);
    }

    public Integer getConsumerGradeById(Integer consumerId) {
        return consumerDAO.getGradeById(consumerId);
    }

    @Transactional
    public int create(ConsumerActivityEntity entity) {
        activityDAO.increaseSelectedCount(entity.getActivityId());
        return consumerActivityDAO.insert(entity);
    }

    public int countConsumerActivitySelectedByTimePart(Integer consumerId, String timePart) {
        return consumerActivityDAO.countConsumerActivitySelectedByTimePart(consumerId, timePart);
    }
}
