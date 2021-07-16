<template>
  <div>
    <el-card class="box-card">
        <el-button size="mini" style="float:left;" @click.native.prevent="editBlog()">添加文章</el-button>
        <el-table class="blog-box" :data="list" stripe style="width: 100%;" height="350">
            <el-table-column prop="title" label="标题">
              <template slot-scope="scope">
                <el-button @click.native.prevent="viewBlog(scope.row)" type="text" size="small">{{scope.row.title}}</el-button>
              </template>
            </el-table-column>
            <el-table-column prop="label" label="标签" width="100"></el-table-column>
            <el-table-column prop="author" label="作者" width="100"></el-table-column>
            <el-table-column prop="create_time" label="创建日期" width="160"></el-table-column>
            <el-table-column prop="update_time" label="修改日期" width="160"></el-table-column>
            <el-table-column label="操作" width="100">
              <template slot-scope="scope">
                <el-button @click.native.prevent="editBlog(scope.row)" type="text" size="small">编辑</el-button>
                <el-button @click.native.prevent="deleteBlog(scope.row)" type="text" size="small" style="color:red;">删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Blogs',
  data () {
    return {
      list:[],
    }
  },
  created() {
    this.getArticles()
  },
  methods: {
    getArticles() {
        this.$axios.get('/article/list').then(res => {
            let result = res.data
            if(result.code == 200) {
                this.list = result.data
            } else {
                console.log(result.msg)
            }
        }).catch(err => {
            console.log(err)
        })
    },
    viewBlog(row) {
      this.$router.push({ path: "/viewBlog", query: { id: row.id } });
    },
    editBlog(row) {
      if(row!=null) {
        this.$router.push({ path: "/editBlog", query: { id: row.id } });
      } else {
        this.$router.push('/editBlog');
      }
    },
    deleteBlog(row) {
      this.$alert('确认删除：'+row.title+ ' 这条博客?', '删除博客', {
          confirmButtonText: '确定',
          callback: action => {
            if(action == 'confirm') {
              this.$axios.post('/article/delete',row.id,{headers:{'Content-Type': 'application/json'}}).then(res => {
                let result = res.data
                if(result.code == 200) {
                  this.$message({
                    type: 'success',
                    message: '删除成功'
                  });
                  this.getArticles()
                }
              }).catch(err => {
                  console.log(err)
              })
            } else {
              this.$message({
                type: 'info',
                message: '取消删除'
              });
            }
          }
      });
    }
  }
}
</script>

<style scoped>
    .box-card {
        width: 65%;
        margin-top: 40px;
        margin-left: 18%;
    }
</style>
