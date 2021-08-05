import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/activity/" + id);

export const create = entity => ajax.post("/admin/activity", entity);

export const deleteItem = id => ajax.pureDelete("/admin/activity/" + id);

export const update = entity => ajax.put("/admin/activity", entity);

export const getPageCount = ( majorName, name) =>
  ajax.get("/admin/activity/page/count", {
    majorName: majorName,
    name: name
  });

export const getPage = (index, majorName, name) =>
  ajax.get("/admin/activity/page/" + index, {
    majorName: majorName,
    name: name
  });

export const listName = () => ajax.pureGet("/admin/activity/names");

export const pageSize = 20;
