<template>
  <div class="activity-select-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-book"></i> 所有活动
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="query-form">
        <el-row :gutter="20">
          <el-col :offset="15" :span="3">
            <el-input
              @keyup.enter.native="query"
              placeholder="活动名"
              v-model="queryForm.activityName"
            />
          </el-col>
          <el-col :span="3">
            <el-input
              @keyup.enter.native="query"
              placeholder="活动发起人"
              v-model="queryForm.teacherName"
            />
          </el-col>
          <el-col :span="3">
            <el-button @click="query" icon="el-icon-search" type="primary"
              >搜索
            </el-button>
          </el-col>
        </el-row>
      </div>

      <el-row justify="center" type="flex">
        <el-pagination
          :current-page.sync="pageIndex"
          :page-size="pageSize"
          :total="pageSize * pageCount"
          @current-change="getPage"
          background
          layout="prev, pager, next"
        >
        </el-pagination>
      </el-row>

      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column align="center" label="活动Id" prop="activityId" />
          <el-table-column align="center" label="活动名" prop="activityName" width="180px" />
          <el-table-column label="活动简介" prop="dailyScore" />
          <el-table-column align="center" label="活动发起人" prop="teacherName" />
          <el-table-column
            align="center"
            label="活动时间"
            prop="time"
            width="130px"
          />
          <el-table-column align="center" label="已选人数" prop="selectedCount" />
          <el-table-column align="center" label="活动容量" prop="maxSize" />
          <el-table-column align="center" label="操作" width="200px">
            <template slot-scope="scope">
              <el-button
                @click="select(scope.row.activityId)"
                size="mini"
                type="success"
                >选择
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/consumer/activitySelect";

export default {
  name: "ConsumerActivitySelect",
  data() {
    return {
      queryForm: {
        activityName: "",
        teacherName: ""
      },
      tableData: [],
      pageSize: api.pageSize,
      pageCount: 1,
      pageIndex: 1
    };
  },
  methods: {
    query() {
      api
        .getPageCount(this.queryForm.activityName, this.queryForm.teacherName)
        .then(res => {
          this.pageCount = res;
          this.pageIndex = 1;
          this.getPage(1);
        });
    },
    getPage(pageIndex) {
      api
        .getPage(
          pageIndex,
          this.queryForm.activityName,
          this.queryForm.teacherName
        )
        .then(res => {
          this.tableData = res;
        });
    },
    select(id) {
      api.select(id).then(() => {
        this.$message.success("选择成功!");
        this.getPage(this.pageIndex);
      });
    }
  },
  created() {
    this.query();
  }
};
</script>

<style scoped></style>
