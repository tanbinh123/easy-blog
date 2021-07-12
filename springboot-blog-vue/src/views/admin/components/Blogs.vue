<template>
  <div>
    <el-card class="box-card">
        <el-table class="blog-box" :data="list" stripe style="width: 100%;" height="350">
            <el-table-column prop="date" label="日期" width="200"></el-table-column>
            <el-table-column prop="name" label="姓名" width="180"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
        </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Blogs',
  data () {
    return {
      list:[{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        },{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
    }
  },
  created() {
    
  },
  methods: {
    
  }
}
</script>

<style scoped>
    .box-card {
        width: 61%;
        margin-top: 40px;
        margin-left: 20%;
    }
    .blog-box {
        background: skyblue;
    }
</style>
