import * as ajax from "../../common/ajax";

export const select = id => ajax.post("/consumer/activity/select/" + id, {});

export const getPageCount = (activityName, teacherName) =>
  ajax.get("/consumer/activity/select/page/count", {
    activityName: activityName,
    teacherName: teacherName
  });

export const getPage = (index, activityName, teacherName) =>
  ajax.get("/consumer/activity/select/page/" + index, {
    activityName: activityName,
    teacherName: teacherName
  });

export const pageSize = 20;
