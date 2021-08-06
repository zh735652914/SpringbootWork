import UserType from "./userType";
import Permission from "./permission";

let SideBarItem = {};

SideBarItem.items = [
  {
    icon: "el-icon-fa fa-bar-chart",
    index: "/visitor",
    title: "用户首页",
    userType: UserType.visitor,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/visitor/activity/select",
    title: "所有活动",
    userType: UserType.visitor,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-bar-chart",
    index: "/consumer",
    title: "用户首页",
    userType: UserType.consumer,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/consumer/activity/select",
    title: "所有活动",
    userType: UserType.consumer,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-edit",
    index: "/consumer/activity",
    title: "已选活动",
    userType: UserType.consumer,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-table",
    index: "/consumer/timetable",
    title: "时间表查询",
    userType: UserType.consumer,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-id-badge",
    index: "/consumer/info",
    title: "信息维护",
    userType: UserType.consumer,
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
    title: "活动查询",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "el-icon-fa fa-table",
    index: "/teacher/timetable",
    title: "用户活动表",
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
    icon: "el-icon-fa fa-user",
    index: "/admin/consumer",
    title: "用户管理",
    userType: UserType.admin,
    permission: Permission.consumer
  },
  {
    icon: "el-icon-fa fa-user-plus",
    index: "/admin/teacher",
    title: "发起人管理",
    userType: UserType.admin,
    permission: Permission.teacher
  },
  {
    icon: "el-icon-fa fa-book",
    index: "/admin/activity",
    title: "活动管理",
    userType: UserType.admin,
    permission: Permission.activity
  },
  {
    icon: "el-icon-fa fa-edit",
    index: "/admin/consumer/activity",
    title: "已选活动修改",
    userType: UserType.admin,
    permission: Permission.consumerActivity
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
