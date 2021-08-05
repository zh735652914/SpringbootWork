import * as ajax from "../../common/ajax";

export const get = id => ajax.pureGet("/teacher/grade/" + id);

export const update = entity => ajax.put("/teacher/grade", entity);

export const getPageCount = (activityName, studentName) =>
  ajax.get("/teacher/grade/page/count", {
    activityName: activityName,
    studentName: studentName
  });

export const getPage = (index, activityName, studentName) =>
  ajax.get("/teacher/grade/page/" + index, {
    activityName: activityName,
    studentName: studentName
  });

export const pageSize = 20;
