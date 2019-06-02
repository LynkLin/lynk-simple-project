import request from '@/axios/axios'
import store from '@/store'
import qs from 'qs'

export default {
  createToken (loginRequest) {
    return request({
      method: 'post',
      url: '/v1/system/auth/',
      data: qs.stringify(loginRequest)
    }).then(response => {
      let payload = {
        'token': response.data.token,
        'userId': response.data.userId
      }
      store.dispatch('auth/saveToken', payload)
      // return auth.token
    })
  },
  deleteToken (token) {
    return request({
      method: 'delete',
      url: '/v1/system/auth/',
      data: qs.stringify(token)
    })
  }
}
