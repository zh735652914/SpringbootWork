package com.springbootWork.manager.admin;

import com.springbootWork.dao.ActivityDAO;
import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ActivityEntity;
import com.springbootWork.model.entity.ConsumerActivityEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.table.ConsumerActivityItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ConsumerActivityManager extends BaseManager {
    private final ActivityDAO activityDAO;
    private final ConsumerActivityDAO consumerActivityDAO;
    private final ConsumerDAO consumerDAO;

    public ConsumerActivityManager(ActivityDAO activityDAO, ConsumerActivityDAO consumerActivityDAO, ConsumerDAO consumerDAO) {
        this.activityDAO = activityDAO;
        this.consumerActivityDAO = consumerActivityDAO;
        this.consumerDAO = consumerDAO;
    }

    public Integer getPageCount(String className, String activityName, String consumerName) {
        int count = consumerActivityDAO.count(className, activityName, consumerName);
        return calcPageCount(count, ConsumerActivityDAO.PAGE_SIZE);
    }

    public List<ConsumerActivityItemVO> getPage(Integer index, String className, String activityName, String consumerName) {
        return consumerActivityDAO.getPage(index, className, activityName, consumerName);
    }

    public ConsumerActivityEntity get(Integer id) {
        return consumerActivityDAO.get(id);
    }

    @Transactional
    public int create(ConsumerActivityEntity entity) {
        activityDAO.increaseSelectedCount(entity.getActivityId());
        return consumerActivityDAO.insert(entity);
    }

    public int update(ConsumerActivityEntity entity) {
        return consumerActivityDAO.update(entity);
    }

    @Transactional
    public int delete(ConsumerActivityEntity entity) {
        activityDAO.decreaseSelectedCount(entity.getActivityId());
        return consumerActivityDAO.delete(entity.getId());
    }

    public ActivityEntity getActivityById(Integer activityId) {
        return activityDAO.get(activityId);
    }

    public ConsumerEntity getConsumerById(Integer consumerId) {
        return consumerDAO.get(consumerId);
    }

    public ConsumerActivityEntity getByActivityIdAndConsumerId(Integer activityId, Integer consumerId) {
        return consumerActivityDAO.getByActivityIdAndConsumerId(activityId, consumerId);
    }

    public Integer getConsumerGradeById(Integer consumerId) {
        return consumerDAO.getGradeById(consumerId);
    }

//    public boolean inSameDepartment(Integer activityId, Integer consumerId) {
//        return activityDAO.getDepartmentIdById(activityId)
//                .equals(consumerDAO.getDepartmentIdById(consumerId));
//    }
}
