package com.springbootWork.service.consumer;

import com.springbootWork.manager.consumer.TimetableManager;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import org.springframework.stereotype.Service;

@Service("consumer_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer consumerId = getUserId();
        return result(manager.listConsumerTimetable(consumerId));
    }
}
