<template>
    <div>
        <div class="info">
          <el-card class="about-box">
            <div class="about-list">
                <div>
                  <b class="title">关于我</b>
                  <div class="aboutMe text">
                    老二刺螈🙆<br>
                    数码爱好者📱<br>
                    想要好好记录下生活📸
                  </div>
                </div>
                <div>
                  <b class="title">博客简介</b>
                  <div class="blog text">
                    记录学习的过程
                  </div>
                </div>
                <div>
                  <b class="title">友情链接</b>
                  <div class="friend text"></div>
                </div>
            </div>
          </el-card>
        </div>
    </div>
</template>

<script>
export default {
  name: 'About',
  components: {},
  data () {
    return {
      
    }
  },
  methods: {

  }
}
</script>

<style scoped>
.info {
  margin-top: 35px;
  margin-left: 25%;
  width: 50%;
  height: 50vh;
}
.about-box {
  width: 100%;
  height: 56vh;
}
.about-list {
  text-align: left;
  font-size: 20px;
}
.title {
  margin-left: 10%;
}
.text {
  width: 80%;
  height: 80px;
  margin-top: 5px;
  margin-left: 10%;
  margin-bottom: 10px;
  text-align: center;
  font-size: 15px;
}
.aboutMe {
  background: rgba(192, 192, 192, 0.3);
}
.blog {
  background: rgba(169, 169, 169, 0.3);
  line-height: 80px;
}
.friend {
  background: rgba(128, 128, 128, 0.3);
}
</style>
