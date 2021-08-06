package com.springbootWork.manager;

import com.springbootWork.dao.AdminDAO;
import com.springbootWork.dao.ConsumerDAO;
import com.springbootWork.dao.TeacherDAO;
import com.springbootWork.dao.VisitorDAO;
import com.springbootWork.model.bo.AuthInfoBO;
import com.springbootWork.model.constant.UserType;
import com.springbootWork.model.entity.ConsumerEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserManager extends BaseManager {
    private final AdminDAO adminDAO;
    private final TeacherDAO teacherDAO;
    private final ConsumerDAO consumerDAO;
    private final VisitorDAO visitorDAO;

    public UserManager(AdminDAO adminDAO, TeacherDAO teacherDAO, ConsumerDAO consumerDAO, VisitorDAO visitorDAO) {
        this.adminDAO = adminDAO;
        this.teacherDAO = teacherDAO;
        this.consumerDAO = consumerDAO;
        this.visitorDAO = visitorDAO;
    }

    public AuthInfoBO getAuthInfoByUsername(String username, Integer userType) {
        if (userType == UserType.CONSUMER) {
            return AuthInfoBO.fromConsumer(consumerDAO.getByNumber(username));
        } else if (userType == UserType.TEACHER) {
            return AuthInfoBO.fromTeacher(teacherDAO.getByNumber(username));
        } else if (userType == UserType.ADMIN) {
            return AuthInfoBO.fromAdmin(adminDAO.getByUsername(username));
        } else if (userType == UserType.VISITOR) {
            return AuthInfoBO.fromVisitor(visitorDAO.getByNumber(username));
        }

        return null;
    }

    public void updateConsumerLastLoginTime(String number) {
        ConsumerEntity entity = consumerDAO.getByNumber(number);
        if (entity == null) {
            return;
        }

        entity.setLastLoginTime(new Date());
        consumerDAO.update(entity);
    }
}
