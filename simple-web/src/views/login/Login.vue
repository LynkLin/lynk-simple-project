<template>
  <div id="login">
    <el-form :model="loginForm" :rules="nullRules" ref="loginForm" class="login-container">
      <h3 class="title">{{$t("app.name")}}</h3>
      <el-form-item prop="userName">
        <el-input v-model="loginForm.userName" :placeholder="$t('login.userName')" :readonly="onLogin" autofocus=true></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" :placeholder="$t('login.password')" :readonly="onLogin"></el-input>
      </el-form-item>
      <el-form-item class="login-button-item">
        <el-button type="primary" @click.native.prevent="submitForm('loginForm')" :loading="onLogin" class="login-button">{{$t("login.login")}}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style lang="scss" scoped>
  .login-container {
    // box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    -ms-border-radius: 5px;
    -o-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
    .login-button-item {
      width: 100%;
      .login-button {
        width: 100%;
      }
    }
  }
</style>

<script>
export default {
  data () {
    return {
      onLogin: false,
      loginForm: {
        userName: '',
        password: ''
      },
      nullRules: {
        userName: [
          {required: true, message: this.$t('login.userName') + this.$t('error.required'), trigger: 'blur'}
        ],
        password: [
          {required: true, message: this.$t('login.password') + this.$t('error.required'), trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.onLogin = true
          var loginRequest = {userName: this.loginForm.userName, password: this.loginForm.password}
          this.$store.dispatch('auth/createToken', loginRequest).then(() => {
            this.$router.push('/home')
            this.onLogin = false
          })
          this.onLogin = false
        } else {
          return false
        }
      })
    }
  }
}
</script>
