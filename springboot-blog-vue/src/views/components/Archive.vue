<template>
    <div>
        <div class="blog-list">
            <el-timeline v-for="(item,index) in blogs" :key="index">
                <el-timeline-item :timestamp="item.create_time" placement="top">
                    <el-card>
                        <h3>{{item.title}}</h3>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Archive',
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
    }
  }
}
</script>

<style scoped>
  .blog-list {
    text-align: left;
    margin-top:7%;
    margin-left: 23%;
    width: 50%;
  }
</style>