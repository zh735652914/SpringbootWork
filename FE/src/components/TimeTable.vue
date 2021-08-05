<template>
  <div class="timetable">
    <table>
      <thead>
        <tr>
          <th>时间</th>
          <th :key="index" v-for="(item, index) in tableData.length">
            {{ "周" + digital2Chinese(item, "week") }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr :key="index" v-for="(lesson, index) in tableData[0].length">
          <td>
            <p>{{digital2Time(lesson)}}</p>
          </td>
          <td :key="activityIndex" v-for="(activity, activityIndex) in tableData">
            <span class="activity-name">
              {{ tableData[activityIndex][index].activityName }}
            </span>
            <p class="teacher-name">
              {{ tableData[activityIndex][index].teacherName }}
            </p>
            <p class="location-name">
              {{ tableData[activityIndex][index].location }}
            </p>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "TimeTable",
  data() {
    return {
      tableData: [
        [
          {
            activityName: "",
            teacherName: "",
            location: ""
          }
        ]
      ]
    };
  },
  methods: {
  digital2Time(num) {
          const character = [
                  "8:00-10:00",
                  "10:00-12:00",
                  "14:00-16:00",
                  "16:00-18:00"
          ];
          return character[num/2];
      },
    updateData(data) {
      this.clearTable();
      for (let i = 0; i < data.length; i++) {
        this.setLesson(data[i]);
      }
    },
    setLesson(item) {
      let split = item.time.split("-");
      let week = parseInt(split[0]);
      let lesson = parseInt(split[1]);
      let length = parseInt(split[2]);
      for (let i = 0; i < length; i++) {
        this.tableData[week - 1][lesson - 1 + i] = {
          activityName: item.activityName,
          teacherName: item.teacherName,
          location: item.location
        };
      }
    },
    clearTable() {
      let table = [];
      for (let i = 0; i < 7; i++) {
        let arr = [];
        for (let i2 = 0; i2 < 10; i2++) {
          arr.push({
            activityName: "",
            teacherName: "",
            location: ""
          });
        }
        table.push(arr);
      }
      this.tableData = table;
    },
    digital2Chinese(num, identifier) {
      const character = [
        "零",
        "一",
        "二",
        "三",
        "四",
        "五",
        "六",
        "七",
        "八",
        "九",
        "十"
      ];
      return identifier === "week" && num === 7 ? "日" : character[num];
    }
  },
  created() {
    this.clearTable();
  }
};
</script>

<style lang="scss" scoped>
table {
  table-layout: fixed;
  width: 100%;

  thead {
    background-color: #67a1ff;

    th {
      color: #fff;
      line-height: 17px;
      font-weight: normal;
    }
  }

  tbody {
    background-color: #eaf2ff;

    td {
      line-height: 0;
      color: #677998;
      height: 50px;

      span {
        line-height: 0.9;
      }
    }

    .activity-name {
      color: #000;
      font-size: 16px;
      font-weight: 200;
    }
  }

  th,
  td {
    width: 60px;
    padding: 2px 2px;
    font-size: 12px;
    text-align: center;
  }

  tr td:first-child {
    color: #333;

    .period {
      font-size: 8px;
    }
  }
}
</style>
