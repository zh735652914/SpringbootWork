import Vue from "vue";
import VueRouter from "vue-router";
import Container from "./views/Container.vue";
import Login from "./views/Login";
import ConsumerActivitySelect from "./views/consumer/ConsumerActivitySelect";
import ConsumerActivity from "./views/consumer/ConsumerActivity";
import ConsumerInfo from "./views/consumer/ConsumerInfo";
import ConsumerTimeTable from "./views/consumer/ConsumerTimeTable";
import ConsumerExam from "./views/consumer/ConsumerExam";
import ConsumerScore from "./views/consumer/ConsumerScore";
import TeacherActivity from "./views/teacher/TeacherActivity";
import TeacherTimetable from "./views/teacher/TeacherTimetable";
import TeacherGrade from "./views/teacher/TeacherGrade";
import AdminDepartment from "./views/admin/AdminDepartment";
import AdminMajor from "./views/admin/AdminMajor";
import AdminClass from "./views/admin/AdminClass";
import AdminConsumer from "./views/admin/AdminConsumer";
import AdminTeacher from "./views/admin/AdminTeacher";
import AdminActivity from "./views/admin/AdminActivity";
import AdminConsumerActivity from "./views/admin/AdminConsumerActivity";
import AdminAdmin from "./views/admin/AdminAdmin";
import Home from "./views/Home";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "container",
    component: Container,
    children: [
      {
        path: "/consumer",
        name: "consumer-home",
        component: Home
      },
      {
        path: "/consumer/activity/select",
        name: "consumer-activity-select",
        component: ConsumerActivitySelect
      },
      {
        path: "/consumer/activity",
        name: "consumer-activity",
        component: ConsumerActivity
      },
      {
        path: "/consumer/timetable",
        name: "consumer-timetable",
        component: ConsumerTimeTable
      },
      {
        path: "/consumer/exam",
        name: "consumer-exam",
        component: ConsumerExam
      },
      {
        path: "/consumer/score",
        name: "consumer-score",
        component: ConsumerScore
      },
      {
        path: "/consumer/info",
        name: "consumer-info",
        component: ConsumerInfo
      },
      {
        path: "/teacher",
        name: "teacher-home",
        component: Home
      },
      {
        path: "/teacher/activity",
        name: "teacher-activity",
        component: TeacherActivity
      },
      {
        path: "/teacher/timetable",
        name: "teacher-timetable",
        component: TeacherTimetable
      },
      {
        path: "/teacher/grade",
        name: "teacher-grade",
        component: TeacherGrade
      },
      {
        path: "/admin",
        name: "admin-home",
        component: Home
      },
      {
        path: "/admin/department",
        name: "admin-department",
        component: AdminDepartment
      },
      {
        path: "/admin/major",
        name: "admin-major",
        component: AdminMajor
      },
      {
        path: "/admin/class",
        name: "admin-class",
        component: AdminClass
      },
      {
        path: "/admin/consumer",
        name: "admin-consumer",
        component: AdminConsumer
      },
      {
        path: "/admin/teacher",
        name: "admin-teacher",
        component: AdminTeacher
      },
      {
        path: "/admin/activity",
        name: "admin-activity",
        component: AdminActivity
      },
      {
        path: "/admin/consumer/activity",
        name: "admin-consumer-activity",
        component: AdminConsumerActivity
      },
      {
        path: "/admin/admin",
        name: "admin-admin",
        component: AdminAdmin
      }
    ]
  },
  {
    path: "/login",
    name: "login",
    component: Login
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
