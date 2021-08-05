import * as ajax from "../../common/ajax";

export const list = () => ajax.pureGet("/student/activity/list");

export const deleteItem = studentActivityId =>
  ajax.pureDelete("/student/activity/" + studentActivityId);
