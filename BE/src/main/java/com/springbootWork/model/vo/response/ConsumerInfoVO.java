package com.springbootWork.model.vo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ConsumerInfoVO {
    private String number;
    private String name;
    private String majorName;
    private String className;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
}
