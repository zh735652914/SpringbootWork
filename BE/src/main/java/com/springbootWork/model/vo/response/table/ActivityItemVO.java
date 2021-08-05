package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class ActivityItemVO {
    private Integer id;
    private String name;
    private String teacherName;
    private Integer grade;
    private Integer credit;
    private String time;
    private Integer selectedCount;
    private Integer maxSize;
}
