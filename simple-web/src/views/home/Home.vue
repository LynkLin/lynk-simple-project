<template>
  <el-container class="home-container">
    <el-header>
      <el-row type="flex" class="head-row">
        <el-col :span="6"><h3>{{$t("app.name")}}</h3></el-col>
        <el-col :span="6"><el-button icon="el-icon-search" circle></el-button></el-col>
      </el-row>
    </el-header>
    <el-main>
      <el-container>
        <el-aside>
          side
        </el-aside>
        <el-main>
          main
        </el-main>
      </el-container>
    </el-main>
  </el-container>
</template>

<style lang="scss" scoped>
  .home-container {
    top: 0px;
    bottom: 0px;
    width: 100%;
    .el-header {
      padding: 0;
      margin: 0;
    };
    .head-row {
      background: #409EFF;
      padding: 0;
      margin: 0;
    }
  }
</style>

<script>
export default {
  data () {
    return {
    }
  }
}
</script>
