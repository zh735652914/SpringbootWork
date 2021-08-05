package com.springbootWork.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ConsumerItemVO {
    private Integer id;
    private String number;
    private String name;
    private Integer sex;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date lastLoginTime;
}
