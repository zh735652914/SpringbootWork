import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/activity/" + id);

export const create = entity => ajax.post("/admin/activity", entity);

export const deleteItem = id => ajax.pureDelete("/admin/activity/" + id);

export const update = entity => ajax.put("/admin/activity", entity);

export const getPageCount = (name) =>
  ajax.get("/admin/activity/page/count", {
    name: name
  });

export const getPage = (index, name) =>
  ajax.get("/admin/activity/page/" + index, {
    name: name
  });

export const listName = () => ajax.pureGet("/admin/activity/names");

export const pageSize = 20;
