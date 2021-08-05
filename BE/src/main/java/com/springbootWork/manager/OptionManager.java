package com.springbootWork.manager;

import com.springbootWork.dao.redis.OptionDAO;
import org.springframework.stereotype.Component;

@Component
public class OptionManager extends BaseManager {
    private static final Boolean DEFAULT_ALLOW_CONSUMER_SELECT = true;
    private static final Boolean DEFAULT_ALLOW_TEACHER_GRADE = true;
    private final OptionDAO optionDAO;

    public OptionManager(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    public Boolean getAllowConsumerSelect() {
        Boolean res = optionDAO.getAllowConsumerSelect();
        if (res == null) {
            optionDAO.setAllowConsumerSelect(DEFAULT_ALLOW_CONSUMER_SELECT);
            res = true;
        }
        return res;
    }

    public void setAllowConsumerSelect(Boolean status) {
        optionDAO.setAllowConsumerSelect(status);
    }

    public Boolean getAllowTeacherGrade() {
        Boolean res = optionDAO.getAllowTeacherGrade();
        if (res == null) {
            optionDAO.setAllowTeacherGrade(DEFAULT_ALLOW_TEACHER_GRADE);
            res = true;
        }
        return res;
    }

    public void setAllowTeacherGrade(Boolean status) {
        optionDAO.setAllowTeacherGrade(status);
    }
}
