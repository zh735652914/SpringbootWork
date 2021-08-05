import * as ajax from "../../common/ajax";

export const get = id => ajax.pureGet("/teacher/grade/" + id);

export const update = entity => ajax.put("/teacher/grade", entity);

export const getPageCount = (activityName, consumerName) =>
  ajax.get("/teacher/grade/page/count", {
    activityName: activityName,
    consumerName: consumerName
  });

export const getPage = (index, activityName, consumerName) =>
  ajax.get("/teacher/grade/page/" + index, {
    activityName: activityName,
    consumerName: consumerName
  });

export const pageSize = 20;
