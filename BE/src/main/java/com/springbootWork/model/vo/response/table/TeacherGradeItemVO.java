package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class TeacherGradeItemVO {
    private Integer studentActivityId;
    private String activityName;
    private String studentName;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
}
