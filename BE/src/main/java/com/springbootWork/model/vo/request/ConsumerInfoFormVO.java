package com.springbootWork.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
public class ConsumerInfoFormVO {
    private String password;

    private String name;

    @Email(message = "邮箱格式不正确")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Range(min = 0, max = 1)
    private Integer sex;
}
