<template>
  <div class="activity-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-book"></i> 活动查询
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="活动Id" prop="id" />
          <el-table-column label="活动名" prop="name" />
          <el-table-column label="年级" prop="grade" />
          <el-table-column label="学分" prop="credit" />
          <el-table-column label="活动时间" prop="time" />
          <el-table-column label="活动地点" prop="location" />
          <el-table-column label="选择人数" prop="selectedCount" />
          <el-table-column label="考试时间" prop="examDate" />
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/teacher/activity";

export default {
  name: "TeacherActivity",
  data() {
    return {
      tableData: []
    };
  },
  methods: {
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    }
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>
