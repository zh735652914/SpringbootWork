package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class StudentActivityItemVO {
    private Integer id;
    private String activityName;
    private String studentName;
    private String className;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
