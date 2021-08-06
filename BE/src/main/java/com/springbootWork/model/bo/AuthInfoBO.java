package com.springbootWork.model.bo;

import com.springbootWork.model.constant.UserType;
import com.springbootWork.model.entity.AdminEntity;
import com.springbootWork.model.entity.ConsumerEntity;
import com.springbootWork.model.entity.TeacherEntity;
import lombok.Data;

@Data
public class AuthInfoBO {
    private Integer id;
    private String username;
    private String password;
    private Integer userType;
    private Integer permission = 0;

    public AuthInfoBO() {
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType) {
        this(id, username, password, userType, 0);
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType, Integer permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
    }

    public static AuthInfoBO fromConsumer(ConsumerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.CONSUMER);
    }

    public static AuthInfoBO fromTeacher(TeacherEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.TEACHER);
    }

    public static AuthInfoBO fromAdmin(AdminEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getUsername(), entity.getPassword(), UserType.ADMIN,
                entity.getPrivilege());
    }

    public static AuthInfoBO fromVisitor(ConsumerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.VISITOR);
    }
}
