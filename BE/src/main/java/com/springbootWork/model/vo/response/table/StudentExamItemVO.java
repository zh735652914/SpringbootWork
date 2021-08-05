package com.springbootWork.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StudentExamItemVO {
    private Integer studentActivityId;
    private String activityName;
    private String teacherName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date examDate;
    private String examLocation;
}
