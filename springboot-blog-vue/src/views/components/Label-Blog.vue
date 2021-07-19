<template>
  <div>
      <div class="label-list">
        <el-button class="labels" v-for="label in labels" :key="label.label" type="info" size="mini" @click="getBlogByLabel(label.label)">
            {{label.label}}
        </el-button>
      </div>
      <div class="label-card">
          <el-card>
              <span style="font-size:15px;">标签：</span>
              <span style="font-size:15px;color:#191970;">{{this.labelSpan}}</span>
              <el-link style="float:right;" :underline="false" @click="setLabelAll()">back</el-link>
          </el-card>
      </div>
      <div class="blog-list">
            <el-card v-for="(item,index) in blogs" :key="index">
                <el-link class="titlelink" :underline="false" @click="toViewBlog(item.id)"><h3>{{item.title}}</h3></el-link>
            </el-card>
        </div>
  </div>
</template>

<script>
export default {
  name: 'Label-Blog',
  data () {
    return {
        labelSpan:'全部',
        labels:[],
        blogs:[],
    }
  },
  created() {
    this.getLabels()
    this.getList()
  },
  methods: {
    getLabels() {
        this.$axios.get('/label/list').then(res => {
            let result = res.data
            if(result.code == 200) {
                this.labels = result.data
            } else {
                console.log(result.msg)
            }
        }).catch(err => {
            console.log(err);
        })
    },
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
    setLabelAll() {
        this.labelSpan = '全部'
        this.getList()
    },
    getBlogByLabel(label) {
        this.labelSpan = label
        this.$axios.post('/article/blogs/label',label,{headers:{'Content-Type': 'application/json'}}).then(res => {
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
.label-list {
    width: 80%;
    height: 80px;
    text-align: center;
    margin-top: 30px;
    margin-left: 10%;
}
.labels {
    margin-left: 10px;
}
.label-card {
    margin-left: 25%;
    width: 50%;
}
.blog-list {
    text-align: left;
    margin-top:2%;
    margin-left: 25%;
    width: 50%;
}
</style>
