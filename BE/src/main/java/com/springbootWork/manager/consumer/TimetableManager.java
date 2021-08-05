package com.springbootWork.manager.consumer;

import com.springbootWork.dao.ConsumerActivityDAO;
import com.springbootWork.manager.BaseManager;
import com.springbootWork.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("consumer_timetableManager")
public class TimetableManager extends BaseManager {
    private final ConsumerActivityDAO consumerActivityDAO;

    public TimetableManager(ConsumerActivityDAO consumerActivityDAO) {
        this.consumerActivityDAO = consumerActivityDAO;
    }

    public List<TimetableItemVO> listConsumerTimetable(Integer consumerId) {
        return consumerActivityDAO.listConsumerTimetable(consumerId);
    }
}
