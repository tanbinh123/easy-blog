<template>
  <div class="b-box">
    <div class="title-label">
      <span style="font-size:22px;float:left">标题：</span>
      <el-input v-model="saveData.title" maxlength="30" size="small" placeholder="请输入内容" 
                style="width:58%;float:left" show-word-limit></el-input>
      <span style="font-size:22px;float:left;margin-left:20px;">分类：</span>
      <el-select v-model="saveData.label" placeholder="请选择" size="small" style="float:left;">
        <el-option
          v-for="item in labelList"
          :key="item.label"
          :label="item.label"
          :value="item.label">
        </el-option>
      </el-select>
    </div>
    <div class="cover-img">
      <el-upload
        class="upload-style"
        action="#"
        :auto-upload="false"
        :on-change="handleChange"
        :on-remove="handleRemove"
        :file-list="coverImgList"
        list-type="picture"
        :limit="1">
        <el-button class="upload-button" size="small" type="primary">点击上传</el-button>
      </el-upload>
    </div>
    <div>
      <span style="font-size:22px;">文章内容</span>
      <mavon-editor
        class="md-box"
        v-model="mdcontent"
        ref="md"
        @imgAdd="mdAddImg"
      />
    </div>
    <div>
      <el-button style="margin-top:50px;" size="small" type="warning" @click="toIndex()">取消</el-button>
      <el-button style="margin-top:50px;" size="small" type="primary" @click="saveBlog()">发布</el-button>
    </div>
    <div class="show-bottom">
      <span>Powered by YCCZTT</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "EditBlog",
  data() {
    return {
      labelList:[],
      //封面图
      coverImgList: [],
      //md文本
      mdcontent:'',
      saveData:{
        id:'',
        //标题
        title:'',
        //标签
        label: '',
        //首图
        cover_img:'',
        //html文本
        content:'',
        //md文本
        markdown_str:'',
        reading:0,
        readable:'Y',
        author:'yccztt',
        create_time:'',
        update_time:''
      }
    };
  },
  created() {
    this.initBlog()
    this.getLabelList()
  },
  methods: {
    //初始化文章：新增/编辑
    initBlog() {
      if(this.$route.query.id) {
        this.$axios.post('/article/blogs',this.$route.query.id,{headers:{'Content-Type': 'application/json'}}).then(res => {
          let result = res.data
          if(result.code == 200) {
            this.saveData = result.data
            this.$refs.md.d_render = result.data.content
            this.$refs.md.d_value = result.data.markdown_str

            var cover_img = result.data.cover_img
            var coverName = cover_img.substr(cover_img.lastIndexOf("/") + 1)
            this.coverImgList.push({
              name:coverName,
              url:result.data.cover_img,
            })
          } else {
            console.log(result.msg)
          }
        }).catch(err => {
          console.log(err);
        })
      }
    },
    //获取分类
    getLabelList() {
      this.$axios.get('/label/list').then(res => {
          let result = res.data
          if(result.code == 200) {
              this.labelList = result.data
          } else {
              console.log(result.msg)
          }
      }).catch(err => {
          console.log(err)
      })
    },
    //上传封面图后方法
    handleChange(file) {
      let formdata = new FormData();
      formdata.append("image", file.raw);
      this.$axios.post("/file/uploadImg", formdata).then((res) => {
        if (res.data.code === 200) {
          this.saveData.cover_img = res.data.url
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch((err) => {
        console.log(err)
      });
    },
    //删除图片方法
    handleRemove(file) {
      //console.log(file)
    },
    //文本编辑器上传图片
    mdAddImg(pos, $file) {
      let formdata = new FormData();
      formdata.append("image", $file);
      this.$axios.post("/file/uploadImg",formdata).then((res) => {
        if (res.data.code === 200) {
          this.$refs.md.$img2Url(pos, res.data.url)
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch((err) => {
        console.log(err)
      });
    },
    toIndex() {
      this.$router.go(-1)
    },
    //保存博客
    saveBlog() {
      this.saveData.content = this.$refs.md.d_render
      this.saveData.markdown_str = this.$refs.md.d_value
      this.$axios.post("/article/save", this.saveData).then((res) => {
        if (res.data.code === 200) {
          this.$message({
            type: 'success',
            message: res.data.msg
          });
          this.$router.go(-1)
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch((err) => {
        console.log(err)
      });
    }
  },
};
</script>

<style>
.b-box {
  margin-top: 30px;
  margin-left: 19%;
  width: 60%;
}
.title-label {
  width: 100%;
  height: 35px;
}
.cover-img {
  width: 100%;
  height: 120px;
}
.upload-style {
  width: 100%;
}
.el-upload-list {
  position: absolute;
  width: 51%;
  margin-top: -75px;
}
.upload-button {
  position: relative;
  margin-left: 740px;
  margin-top: 45px;
}
.md-box {
  width: 100%;
  height: 80vh;
}
.show-bottom {
  color:#909399;
  margin-top: 8%;
  height: 60px;
}
</style>