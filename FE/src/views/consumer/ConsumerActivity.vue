<template>
  <div class="activity-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-edit"></i> 已选活动
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="活动Id" prop="consumerActivityId" />
          <el-table-column label="活动名" prop="activityName" />
          <el-table-column label="活动简介" prop="activityDescribe" />
          <el-table-column label="活动时间" prop="activityTime" />
          <el-table-column label="活动地点" prop="activityLocation" />
          <el-table-column label="活动发起人" prop="teacherName" />
          <el-table-column align="center" label="操作" width="200px">
            <template slot-scope="scope">
              <el-button
                @click="deleteItem(scope.row.consumerActivityId)"
                size="mini"
                type="danger"
                >退选
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/consumer/activity";

export default {
  name: "ConsumerActivity",
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
    },
    deleteItem(consumerActivityId) {
      api.deleteItem(consumerActivityId).then(() => {
        this.$message.success("退选成功!");
        this.getList();
      });
    }
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>
