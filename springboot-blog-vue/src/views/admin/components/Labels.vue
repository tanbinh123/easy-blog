<template>
  <div>
      <div class="label-list">
        <el-tag class="labels" v-for="label in labels" :key="label.label" type="info" closable size="medium" @close="deleteLabel(label.id)">
            {{label.label}}
        </el-tag>
        <el-button class="button-new-tag" size="small" @click="newLabel">+ New Label</el-button>
      </div>
  </div>
</template>

<script>
export default {
  name: 'Labels',
  data () {
    return {
      labels:[],
    }
  },
  created() {
    this.getLabels()
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
    addLabel(label) {
        this.$axios.get('/label/add/'+label,{headers:{'Content-Type': 'application/json'}}).then(res => {
            if(res.data.code == 200){
              this.$message({
                type: 'success',
                message: '新增标签: ' + label
              });
              this.getLabels()
            } else {
              this.$message({
                type: 'warning',
                message: '新增标签失败: ' + res.data.message
              });
            }
        }).catch(err => {
            console.log(err);
        })
    },
    newLabel() {
        this.$prompt('请输入新增标签', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          this.addLabel(value)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消新增'
          });       
        });
    },
    deleteLabel(labelId) {
        this.$axios.get('/label/delete/'+labelId,{headers:{'Content-Type': 'application/json'}}).then(res => {
            if(res.data.code == 200){
              this.$message({
                type: 'success',
                message: '删除标签成功'
              });
              this.getLabels()
            } else {
              this.$message({
                type: 'warning',
                message: '删除标签失败'
              });
            }
        }).catch(err => {
            console.log(err);
        })
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
    .button-new-tag {
        margin-left: 10px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
</style>
