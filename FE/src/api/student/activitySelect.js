import * as ajax from "../../common/ajax";

export const select = id => ajax.post("/student/activity/select/" + id, {});

export const getPageCount = (activityName, teacherName) =>
  ajax.get("/student/activity/select/page/count", {
    activityName: activityName,
    teacherName: teacherName
  });

export const getPage = (index, activityName, teacherName) =>
  ajax.get("/student/activity/select/page/" + index, {
    activityName: activityName,
    teacherName: teacherName
  });

export const pageSize = 20;
