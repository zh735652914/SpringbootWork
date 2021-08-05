package com.springbootWork.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ActivityItemVO {
    private Integer id;
    private String name;
    private String activitySponsorName;
    private String departmentName;
    private Integer year;
    private String time;
    private Integer selectedCount;
    private Integer maxSize;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date activity_start_date;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date activity_end_date;
}
