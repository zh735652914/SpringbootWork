import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/consumer/" + id);

export const create = entity => ajax.post("/admin/consumer", entity);

export const deleteItem = id => ajax.pureDelete("/admin/consumer/" + id);

export const update = entity => ajax.put("/admin/consumer", entity);

export const getPageCount = (name) =>
  ajax.get("/admin/consumer/page/count", {
    name: name
  });

export const getPage = (index,name) =>
  ajax.get("/admin/consumer/page/" + index, {

    name: name
  });

export const listName = () => ajax.pureGet("/admin/consumer/names");

export const pageSize = 20;
