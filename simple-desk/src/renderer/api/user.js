import request from '@/axios/axios'
// import store from '@/store'
import axios from 'axios'

function getUser (userId) {
  return request({
    method: 'get',
    url: '/v1/system/user/' + userId
  }).then(response => {
    var user = response.data
    return user
  })
}

function getUserPermissions (userId) {
  return request({
    method: 'get',
    url: 'v1/system/user/' + userId + '/permissions'
  }).then(response => {
    return response.data
  })
}

export default {
  getUser,
  getUserPermissions,
  getUserInfo (userId) {
    return axios.all([getUser(userId), getUserPermissions(userId)]).then(axios.spread(function (user, permissions) {
      return {
        user: user,
        permissions: permissions
      }
    }))
  }
}
