package com.springbootWork.model.vo.response.table;

import lombok.Data;

@Data
public class TimetableItemVO {
    private String time;
    private String activityName;
    private String teacherName;
    private String location;
}
