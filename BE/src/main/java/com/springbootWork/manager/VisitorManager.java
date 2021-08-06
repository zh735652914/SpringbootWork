package com.springbootWork.manager;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.model.bo.ConsumerActivitySelectItemBO;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VisitorManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final ConsumerDAO consumerDAO;
    private final ConsumerActivityDAO consumerActivityDAO;

    public VisitorManager(ActivityDAO activityDAO, ConsumerDAO consumerDAO, ConsumerActivityDAO consumerActivityDAO) {
        this.activityDAO = activityDAO;
        this.consumerDAO = consumerDAO;
        this.consumerActivityDAO = consumerActivityDAO;
    }

    public Integer getPageCount(String activityName, String teacherName) {
        return calcPageCount(activityDAO.countVisitorCanSelect(activityName, teacherName), ConsumerActivityDAO.PAGE_SIZE);
    }

    public List<ConsumerActivitySelectItemBO> getPage(Integer index, String activityName, String teacherName) {
        return activityDAO.getVisitorCanSelectPage(index, activityName, teacherName);
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

    @Transactional
    public int create(ConsumerActivityEntity entity) {
        activityDAO.increaseSelectedCount(entity.getActivityId());
        return consumerActivityDAO.insert(entity);
    }

    public int countConsumerActivitySelectedByTimePart(Integer consumerId, String timePart) {
        return consumerActivityDAO.countConsumerActivitySelectedByTimePart(consumerId, timePart);
    }
}
