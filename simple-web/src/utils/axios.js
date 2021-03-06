import axios from 'axios'
import { Notification } from 'element-ui'
import store from '@/store'
import i18n from '@/i18n'
import router from '@/router'

const service = axios.create({
  baseURL: process.env.BASE_URL,
  timeout: 10000
})
service.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

// 通用request拦截器
service.interceptors.request.use(config => {
  var token = store.getters['auth/token']
  if (token) {
    config.headers.userToken = token
  }
  return config
}, error => {
  // Do something with request error
  console.log(error)
  Promise.reject(error)
})

service.interceptors.response.use(response => {
  // response like:
  // status
  // errorCode
  // error
  // message
  // data
  var status = response.data.status
  if (status !== '0') {
    Notification.error({
      title: i18n.t('error.title'),
      message: '[' + response.data.errorCode + '] ' + response.data.error
    })
    return Promise.reject(response.data.error)
  } else {
    return response.data
  }
}, error => {
  // Do something with response error
  var status = error.response.status
  switch (status) {
    case 401:
      router.push('/login')
      break
    default:
      Notification.error({
        title: i18n.t('error.title'),
        message: error.message
      })
  }
  return Promise.reject(error)
})

export default service
