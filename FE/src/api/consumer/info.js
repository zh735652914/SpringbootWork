import * as ajax from "../../common/ajax";

export const get = () => ajax.pureGet("/consumer/info");

export const update = entity => ajax.put("/consumer/info", entity);
