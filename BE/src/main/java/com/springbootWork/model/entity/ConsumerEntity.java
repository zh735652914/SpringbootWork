package com.springbootWork.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName("rc_consumer")
@Data
public class ConsumerEntity {
    public static final String ID = "consumer_id";
    public static final String NUMBER = "consumer_number";
    public static final String NAME = "consumer_name";
    public static final String PASSWORD = "consumer_password";
    public static final String EMAIL = "consumer_email";
    public static final String BIRTHDAY = "consumer_birthday";
    public static final String SEX = "consumer_sex";
    public static final String LAST_LOGIN_TIME = "consumer_last_login_time";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @Length(min = 12, max = 12, message = "账号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "用户姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @Email(message = "邮箱格式不正确")
    @TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = BIRTHDAY, updateStrategy = FieldStrategy.IGNORED)
    private Date birthday;

    @Range(min = 0, max = 1)
    @TableField(SEX)
    private Integer sex;

    @TableField(LAST_LOGIN_TIME)
    private Date lastLoginTime;
}
