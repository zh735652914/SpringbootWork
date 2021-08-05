package com.springbootWork.config.themis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Admin {
    // 无权限
    int NO = 0;
    // 系管理
    int DEPARTMENT_MANAGE = 1;
    // 专业管理
    int MAJOR_MANAGE = 2;
    // 班级管理
    int CLASS_MANAGE = 4;
    // 学生管理
    int CONSUMER_MANAGE = 8;
    // 教师管理
    int TEACHER_MANAGE = 16;
    // 活动管理
    int ACTIVITY_MANAGE = 32;
    // 学生选课管理
    int CONSUMER_ACTIVITY_MANAGE = 64;
    // 管理员管理
    int ADMIN_MANAGE = 128;
    // 所有权限
    int ALL = 255;

    int value() default 0;
}
