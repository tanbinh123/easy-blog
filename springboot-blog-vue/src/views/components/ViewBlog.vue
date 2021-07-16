<template>
  <div>
      <div class="blog-box">
        <div class="title">
          {{blog.title}}
        </div>
        <div class="info">
          {{blog.create_time}}
          <span style="margin-left:7px;margin-right:7px;">/</span>
          <span>{{blog.reading}} read</span>
          <span style="margin-left:10px;">
            <el-link style="margin-top:-0.3%;" :underline="false"># {{blog.label}}</el-link>
          </span>
          <el-link style="float:right;" :underline="false" @click="toIndex()">back</el-link>
        </div>
        <el-image class="cover_img" fit="cover" :src="blog.cover_img"></el-image>
        <el-card class="content-box">
          <div class="content" v-html="blog.content"></div>
        </el-card>
        <div class="show-bottom">
          <span>Powered by YCCZTT</span>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'ViewBlog',
  data () {
    return {
      blog: {}
    }
  },
  created() {
    this.getBlogById(this.$route.query.id)
  },
  methods: {
    getBlogById(id) {
      this.$axios.post('/article/blogs',id,{headers:{'Content-Type': 'application/json'}}).then(res => {
        let result = res.data
        if(result.code == 200) {
          this.blog = result.data
        } else {
          console.log(result.msg)
        }
      }).catch(err => {
        console.log(err);
      })
    },
    toIndex() {
      this.$router.go(-1)
    }
  }
}
</script>

<style scoped>
.blog-box {
  margin-left: 18%;
  margin-top: 20px;
  width: 65%;
  height: 400px;
}
.title {
  width: 100%;
  height: 40px;
  font-size: 30px;
}
.info {
  color:#909399;
  margin-top: 10px;
  width: 100%;
  height: 20px;
  font-size: 15px;
}
.cover_img {
  margin-top: 20px;
  width: 100%; 
  height: 370px;
}
.content-box {
  text-align: left;
  margin-top: 20px;
  width: 100%;
}
.show-bottom {
  color:#909399;
  margin-top: 8%;
  height: 60px;
}
</style>
