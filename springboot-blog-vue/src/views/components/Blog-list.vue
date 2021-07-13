<template>
  <div>
    <div class="blog-list" v-for="(item,index) in blogs" :key="index">
      <div class="title" @click="toViewBlog(item.id)">
        <el-link class="titlelink" :underline="false">{{item.title}}</el-link>
      </div>
      <div class="info">
        {{item.create_time}}
        <span style="margin-left:7px;margin-right:7px;">/</span>
        <span>{{item.reading}} read</span>
        <span style="margin-left:10px;">
          <el-link style="margin-top:-0.3%;" :underline="false"># {{item.label}}</el-link>
        </span>
      </div>
      <el-image class="blog-img" fit="cover" :src="item.cover_img" @click="toViewBlog(item.id)"></el-image>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Blog-list',
  data () {
    return {
      blogs:[],
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.$axios.get('/article/list').then(res => {
        let result = res.data
        if(result.code == 200) {
          this.blogs = result.data
        } else {
          console.log(result.msg)
        }
      }).catch(err => {
        console.log(err);
      })
    },
    toViewBlog(id) {
      this.$router.push({ path: "/viewBlog", query: { id: id } });
    }
  }
}
</script>

<style scoped>
  .blog-list {
    text-align: center;
    margin-top:7%;
    margin-left: 10%;
    width: 80%;
    height: 500px;
  }
  .title {
    width: 100%;
    height: 30px;
  }
  .titlelink {
    font-size: 35px;
    font-weight:bold;
  }
  .info {
    color:#909399;
    margin-top: 35px;
    width: 100%;
    height: 15px;
    font-size: 15px;
  }
  .blog-img {
    margin-top: 35px;
    width: 100%; 
    height: 370px;
    transition:all 0.3s ease;
  }
  .blog-img:hover {
    transform:scale(1.01,1.01);
    transition:all 0.3s ease;
  }
</style>
