import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/student/activity/" + id);

export const create = entity => ajax.post("/admin/student/activity", entity);

export const deleteItem = id => ajax.pureDelete("/admin/student/activity/" + id);

export const update = entity => ajax.put("/admin/student/activity", entity);

export const getPageCount = (className, activityName, studentName) =>
  ajax.get("/admin/student/activity/page/count", {
    className: className,
    activityName: activityName,
    studentName: studentName
  });

export const getPage = (index, className, activityName, studentName) =>
  ajax.get("/admin/student/activity/page/" + index, {
    className: className,
    activityName: activityName,
    studentName: studentName
  });

export const pageSize = 20;
