import * as ajax from "../../common/ajax";

export const list = () => ajax.pureGet("/consumer/activity/list");

export const deleteItem = consumerActivityId =>
  ajax.pureDelete("/consumer/activity/" + consumerActivityId);
