<template>
  <div class="b-box">
    <div class="title-label">
      <span style="font-size:22px;float:left">标题：</span>
      <el-input v-model="title" maxlength="30" size="small" placeholder="请输入内容" 
                style="width:58%;float:left" show-word-limit></el-input>
      <span style="font-size:22px;float:left;margin-left:20px;">分类：</span>
      <el-select v-model="label" placeholder="请选择" size="small" style="float:left;">
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
        action="#"
        :auto-upload="false"
        :on-change="handleChange"
        :on-remove="handleRemove"
        :file-list="coverImg"
        list-type="picture"
        :limit="1">
        <el-button size="small" type="primary">点击上传</el-button>
      </el-upload>
    </div>
    <!-- <div class="b-edit">
      <mavon-editor
        style="height: 500px"
        v-model="content"
        ref="md"
        @change="change"
        @imgAdd="imgAdd"
      />
      <button @click="submit">提交</button>
    </div> -->
  </div>
</template>

<script>
export default {
  name: "EditBlog",
  data() {
    return {
      //标题
      title:'',
      //标签
      label: '',
      labelList:[{
        label: '黄金糕'
      }, {
        label: '双皮奶'
      }, {
        label: '蚵仔煎'
      }],
      //封面图
      coverImg: [],
      content: "",
      html: "",
      configs: {},
      saveDate: {
        id: "",
        content: "",
        createTime: "",
        updateTime: "",
        isDelete: 0,
      },
    };
  },
  methods: {
    //上传封面图后方法
    handleChange(file) {
      console.log(file);
    },
    //删除图片方法
    handleRemove(file) {
      console.log(file);
    },
    // 将图片上传到服务器，返回地址替换到md中
    imgAdd(pos, $file) {
      let formdata = new FormData();
      formdata.append("image", $file);
      //访问后台服务器方法
      this.$axios
        .post("/blog/uploadImg", formdata)
        .then((response) => {
          if (response.data.code === 200) {
            this.$refs.md.$img2Url(pos, response.data.url);
          } else {
            this.$message.error(response.data.msg);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    change(value, render) {
      this.html = render;
      console.log(this.$refs.md.d_render);
      console.log(this.$refs.md.d_value);
    },
    // 提交
    submit() {
      this.saveDate.content = this.html;
      this.$axios
        .post("/blog/edit", this.saveDate)
        .then((response) => {
          if (response.data.code === 200) {
            alert("保存成功");
            this.$router.push("/");
          } else {
            alert("保存失败");
          }
        })
        .catch((err) => {
          console.log(err);
        });
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
  height: 80vh;
}
.title-label {
  width: 100%;
  height: 35px;
}
.cover-img {
  background: red;
  width: 100%;
  height: 100px;
}
.b-edit {
  height: 600px;
  width: 100%;
  margin: 0 auto;
  text-align: center;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>