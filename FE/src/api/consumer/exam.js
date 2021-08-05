import * as ajax from "../../common/ajax";

export const list = () => ajax.pureGet("/consumer/exam/list");
