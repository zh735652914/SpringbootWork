package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class StudentActivitySelectedItemVO {
    private Integer studentActivityId;
    private String activityName;
    private String teacherName;
    private Integer credit;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
