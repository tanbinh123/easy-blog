<template>
  <div>
    <div style="margin-top:50px;">
      <el-avatar :size="120" src="http://localhost:8081/upload/avatar/avatar.jpg"></el-avatar>
    </div>
    <div class="sname">
      <el-link style="font-size:30px;font-weight:bold;" :underline="false" @click="editUser">YCCZTT</el-link>
    </div>
    <User ref="editUser"></User>
    <div class="sremark">
      <span>我们每天度过的日常，都是连续不断的奇迹!</span>
    </div>
    <div class="linktag">
      <el-link class="link" :underline="false" @click="changeType('article')">文章</el-link>
      <el-link class="link" :underline="false" @click="changeType('type')">分类</el-link>
    </div>
    <Blogs v-if="linkType == 'article'"></Blogs>
    <Labels v-if="linkType == 'type'"></Labels>
    <div class="show-bottom">
      <span>Powered by YCCZTT</span>
    </div>
  </div>
</template>

<script>
import Labels from './components/Labels.vue'
import User from './components/User.vue'
import Blogs from './components/Blogs.vue'
export default {
  name: 'Management',
  components: {
    Labels,
    User,
    Blogs
  },
  data () {
    return {
      userId:'',
      linkType:'article'
    }
  },
  created() {
    this.userId = this.$route.query.id
  },
  methods: {
    changeType(type) {
      this.linkType = type
    },
    editUser() {
      this.$refs['editUser'].userInfo(this.userId)
    }
  }
}
</script>

<style scoped>
  .sname {
    margin-top:25px;
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
