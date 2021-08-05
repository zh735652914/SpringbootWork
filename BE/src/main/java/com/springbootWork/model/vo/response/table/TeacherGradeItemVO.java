package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class TeacherGradeItemVO {
    private Integer consumerActivityId;
    private String activityName;
    private String consumerName;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
