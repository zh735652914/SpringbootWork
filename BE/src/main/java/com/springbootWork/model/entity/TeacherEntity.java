package com.springbootWork.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("rc_teacher")
@Data
public class TeacherEntity {
    public static final String ID = "teacher_id";
    public static final String NUMBER = "teacher_number";
    public static final String NAME = "teacher_name";
    public static final String PASSWORD = "teacher_password";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @Length(min = 12, max = 12, message = "账号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "发起人姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;
}
