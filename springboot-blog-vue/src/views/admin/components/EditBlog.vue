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
        v-model="content"
        ref="md"
        @change="change"
        @imgAdd="imgAdd"
      />
    </div>
    <el-button style="margin-top:50px;" size="small" type="primary">发布</el-button>
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
      labelList:[{
        label: '黄金糕'
      }, {
        label: '双皮奶'
      }, {
        label: '蚵仔煎'
      }],
      //封面图
      coverImgList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
      saveData:{
        //标题
        title:'',
        //标签
        label: '',
        //首图
        converImgUrl:'',
      }
    };
  },
  methods: {
    //上传封面图后方法
    handleChange(file) {
      let formdata = new FormData();
      formdata.append("image", file.raw);
      this.$axios.post("/file/uploadImg", formdata).then((res) => {
        if (res.data.code === 200) {
          this.saveData.converImgUrl = res.data.url
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        console.log(err);
      });
    },
    //删除图片方法
    handleRemove(file) {
      //console.log(file);
    },
  },
};
</script>

<style>
.b-box {
  background: skyblue;
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