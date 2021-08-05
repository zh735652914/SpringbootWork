package com.springbootWork.manager.consumer;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.vo.response.table.ConsumerActivitySelectedItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("consumer_ActivityManager")
public class ActivityManager extends BaseManager {
    private final ConsumerActivityDAO consumerActivityDAO;
    private final ActivityDAO activityDAO;

    public ActivityManager(ConsumerActivityDAO consumerActivityDAO, ActivityDAO activityDAO) {
        this.consumerActivityDAO = consumerActivityDAO;
        this.activityDAO = activityDAO;
    }

    public ConsumerActivityEntity getConsumerActivityById(Integer consumerActivityId) {
        return consumerActivityDAO.get(consumerActivityId);
    }

    @Transactional
    public int deleteConsumerActivity(ConsumerActivityEntity consumerActivityEntity) {
        activityDAO.decreaseSelectedCount(consumerActivityEntity.getActivityId());
        return consumerActivityDAO.delete(consumerActivityEntity.getId());
    }

    public List<ConsumerActivitySelectedItemVO> listConsumerActivitySelected(Integer consumerId) {
        return consumerActivityDAO.listConsumerActivitySelected(consumerId);
    }
}
