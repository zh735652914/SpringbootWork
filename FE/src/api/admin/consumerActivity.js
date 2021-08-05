import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/consumer/activity/" + id);

export const create = entity => ajax.post("/admin/consumer/activity", entity);

export const deleteItem = id => ajax.pureDelete("/admin/consumer/activity/" + id);

export const update = entity => ajax.put("/admin/consumer/activity", entity);

export const getPageCount = (className, activityName, consumerName) =>
  ajax.get("/admin/consumer/activity/page/count", {
    className: className,
    activityName: activityName,
    consumerName: consumerName
  });

export const getPage = (index, className, activityName, consumerName) =>
  ajax.get("/admin/consumer/activity/page/" + index, {
    className: className,
    activityName: activityName,
    consumerName: consumerName
  });

export const pageSize = 20;
