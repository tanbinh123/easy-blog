<template>
  <div>
    <el-dialog title="用户信息" :visible.sync="dialogVisible" width="25%" :before-close="close">
      <el-form ref="form" :model="form" label-width="45px" size="mini">
        <el-form-item label="昵称:">
          <el-input v-model="form.nickname" disabled></el-input>
        </el-form-item>
        <el-form-item label="邮箱:">
          <el-input v-model="form.email" disabled></el-input>
        </el-form-item>
        <el-form-item label="电话:">
          <el-input v-model="form.phone" disabled></el-input>
        </el-form-item>
        <el-form-item label="简介:">
          <el-input type="textarea" :rows="3" v-model="form.introduction" disabled></el-input>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'User',
  data () {
    return {
      dialogVisible: false,
      form:{
        nickname:'',
        email:'',
        phone:'',
        introduction:'',
      }
    }
  },
  created() {
  },
  methods: {
    close() {
      this.dialogVisible = false
    },
    userInfo(userId) {
      this.dialogVisible = true
      this.getUser(userId);
    },
    getUser(userId) {
      this.$axios.get('/user/query/'+userId ,{headers:{'Content-Type': 'application/json'}}).then(res => {
        var result = res.data.data
        this.form = result
      }).catch(err => {
        console.log(err);
      })
    }
  }
}
</script>

<style scoped>

</style>
