import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/teacher/" + id);

export const create = entity => ajax.post("/admin/teacher", entity);

export const deleteItem = id => ajax.pureDelete("/admin/teacher/" + id);

export const update = entity => ajax.put("/admin/teacher", entity);

export const getPageCount = (name) =>
  ajax.get("/admin/teacher/page/count", {
    name: name
  });

export const getPage = (index, name) =>
  ajax.get("/admin/teacher/page/" + index, {
    name: name
  });

export const listName = () => ajax.pureGet("/admin/teacher/names");

export const pageSize = 20;
