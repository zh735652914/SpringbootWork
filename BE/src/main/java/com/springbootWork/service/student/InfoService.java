package com.springbootWork.service.consumer;

import com.springbootWork.manager.consumer.InfoManager;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.vo.request.ConsumerInfoFormVO;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.service.BaseService;
import com.springbootWork.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService extends BaseService {
    private final UserService userService;

    private final InfoManager manager;

    public InfoService(UserService userService, InfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getConsumerInfoByConsumerId(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated ConsumerInfoFormVO consumerInfoForm) {
        ConsumerEntity consumer = manager.getConsumerById(getUserId());

        String password = consumerInfoForm.getPassword();
        if (password == null || password.equals("")) {
            password = consumer.getPassword();
        } else {
            password = userService.computePasswordHash(password);
        }

        BeanUtils.copyProperties(consumerInfoForm, consumer);
        consumer.setPassword(password);
        manager.updateConsumer(consumer);

        return result("更新成功");
    }
}
