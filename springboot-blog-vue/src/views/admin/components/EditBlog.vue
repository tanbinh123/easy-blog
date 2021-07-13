<template>
  <div class="b-edit">
    <mavon-editor
      style="height: 500px"
      v-model="content"
      ref="md"
      @change="change"
      @imgAdd="imgAdd"
    />
    <button @click="submit">提交</button>
  </div>
</template>

<script>
export default {
  name: "EditBlog",
  data() {
    return {
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
  created() {},
  methods: {
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
.b-edit {
  height: 600px;
  width: 960px;
  margin: 0 auto;
  text-align: center;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>