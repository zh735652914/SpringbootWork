import UserType from "./userType";
import Permission from "./permission";

let SideBarItem = {};

SideBarItem.items = [
  {
    icon: "el-icon-fa fa-bar-chart",
    index: "/student",
    title: "用户首页",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/student/activity/select",
    title: "所有活动",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-edit",
    index: "/student/activity",
    title: "用户活动",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-table",
    index: "/student/timetable",
    title: "时间表查询",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-eye",
    index: "/student/exam",
    title: "考试查询",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-id-badge",
    index: "/student/info",
    title: "信息维护",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-bar-chart",
    index: "/teacher",
    title: "用户首页",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/teacher/activity",
    title: "授课查询",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-table",
    index: "/teacher/timetable",
    title: "用户课表",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-edit",
    index: "/teacher/grade",
    title: "成绩录入",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-bar-chart",
    index: "/admin",
    title: "活动运营人员首页",
    userType: UserType.admin,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-fort-awesome",
    index: "/admin/department",
    title: "系管理",
    userType: UserType.admin,
    permission: Permission.department
  },
  {
    icon: "el-icon-fa fa-graduation-cap",
    index: "/admin/major",
    title: "专业管理",
    userType: UserType.admin,
    permission: Permission.major
  },
  {
    icon: "el-icon-fa fa-group",
    index: "/admin/class",
    title: "班级管理",
    userType: UserType.admin,
    permission: Permission.class
  },
  {
    icon: "el-icon-fa fa-user",
    index: "/admin/student",
    title: "用户管理",
    userType: UserType.admin,
    permission: Permission.student
  },
  {
    icon: "el-icon-fa fa-user-plus",
    index: "/admin/teacher",
    title: "教师管理",
    userType: UserType.admin,
    permission: Permission.teacher
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/admin/activity",
    title: "课程管理",
    userType: UserType.admin,
    permission: Permission.activity
  },
  {
    icon: "el-icon-fa fa-edit",
    index: "/admin/student/activity",
    title: "选课修改",
    userType: UserType.admin,
    permission: Permission.studentActivity
  },
  {
    icon: "el-icon-fa fa-id-badge",
    index: "/admin/admin",
    title: "运营人员管理",
    userType: UserType.admin,
    permission: Permission.admin
  }
];

export default SideBarItem;
