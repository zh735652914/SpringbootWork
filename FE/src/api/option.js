import { pureGet, put } from "../common/ajax";

export const getAllowConsumerSelect = () =>
  pureGet("/option/allowConsumerSelect");

export const setAllowConsumerSelect = option =>
  put("/option/allowConsumerSelect", {
    option: option
  });

export const getAllowTeacherGrade = () => pureGet("/option/allowTeacherGrade");

export const setAllowTeacherGrade = option =>
  put("/option/allowTeacherGrade", {
    option: option
  });
