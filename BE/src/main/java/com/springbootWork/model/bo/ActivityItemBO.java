package com.springbootWork.model.bo;

import lombok.Data;

@Data
public class ActivityItemBO {
    private Integer id;
    private String name;
    private String teacherName;
    private Integer grade;
    private Integer credit;
    private String time;
    private Integer selectedCount;
    private Integer maxSize;
}
