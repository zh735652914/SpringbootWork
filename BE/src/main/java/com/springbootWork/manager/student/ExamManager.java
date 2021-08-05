package com.springbootWork.manager.consumer;

import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.ConsumerExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final ConsumerActivityDAO consumerActivityDAO;

    public ExamManager(ConsumerActivityDAO consumerActivityDAO) {
        this.consumerActivityDAO = consumerActivityDAO;
    }

    public List<ConsumerExamItemVO> listConsumerExam(Integer consumerId) {
        return consumerActivityDAO.listConsumerExam(consumerId);
    }
}
