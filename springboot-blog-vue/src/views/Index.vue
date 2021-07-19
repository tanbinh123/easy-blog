<template>
  <div>
    <div style="margin-top:50px;">
      <el-avatar :size="120" src="http://localhost:8081/upload/avatar/avatar.jpg"></el-avatar>
    </div>
    <div class="sname">
      <span><b>YCCZTT</b></span>
    </div>
    <div class="sremark">
      <span>我们每天度过的日常，都是连续不断的奇迹!</span>
    </div>
    <div class="linktag">
      <el-link class="link" :underline="false" @click="changeType('index')">首页</el-link>
      <!-- <el-link class="link" :underline="false" @click="changeType('archive')">归档</el-link> -->
      <el-link class="link" :underline="false" @click="changeType('label')">标签</el-link>
      <el-link class="link" :underline="false" @click="changeType('about')">关于</el-link>
    </div>
    <div class="iconbtn">
      <el-link :underline="false"><i class="iconfont icon-github"></i></el-link>
      <span style="margin-left:10px;margin-right:10px;"></span>
      <el-link :underline="false" href="https://web.okjike.com/me" target="_blank"><i class="iconfont icon-jishufuwu"></i></el-link>
    </div>
    <BlogList v-if="linkType=='index'"></BlogList>
    <Archive v-if="linkType=='archive'"></Archive>
    <LabelBlog v-if="linkType=='label'"></LabelBlog>
    <About v-if="linkType=='about'"></About>
    <div class="show-bottom">
      <span>Powered by YCCZTT</span>
    </div>
  </div>
</template>

<script>
import BlogList from './components/Blog-list.vue'
import Archive from './components/Archive.vue'
import LabelBlog from './components/Label-Blog.vue'
import About from './components/About.vue'
export default {
  name: 'Index',
  components: {
    BlogList,
    Archive,
    LabelBlog,
    About
  },
  data () {
    return {
      linkType:'index'
    }
  },
  methods: {
    changeType(type) {
      this.linkType = type
    }
  }
}
</script>

<style scoped>
  .sname {
    margin-top:25px;
    font-size:30px;
  }
  .sremark {
    margin-top:35px;
    color:#909399;
  }
  .linktag {
    margin-top:40px;
  }
  .link {
    font-weight: 500;
    font-size: 15px;
    margin-left: 20px;
    margin-right: 20px;
  }
  .iconbtn {
    margin-top:35px;
  }
  .show-bottom {
    color:#909399;
    margin-top: 8%;
    margin-bottom: 3%;
  }
</style>
