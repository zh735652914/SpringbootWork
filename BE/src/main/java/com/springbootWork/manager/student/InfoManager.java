package com.springbootWork.manager.consumer;

import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.response.ConsumerInfoVO;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final ConsumerDAO consumerDAO;

    public InfoManager(ConsumerDAO consumerDAO) {
        this.consumerDAO = consumerDAO;
    }

    public ConsumerInfoVO getConsumerInfoByConsumerId(Integer consumerId) {
        return consumerDAO.getConsumerInfoById(consumerId);
    }

    public ConsumerEntity getConsumerById(Integer consumerId) {
        return consumerDAO.get(consumerId);
    }

    public int updateConsumer(ConsumerEntity entity) {
        return consumerDAO.update(entity);
    }
}
