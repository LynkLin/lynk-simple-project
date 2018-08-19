import request from '@/utils/axios'
import axios from 'axios'

export function getUser (userId) {
  return request({
    method: 'get',
    url: '/v1/system/user/' + userId
  }).then(response => {
    var token = response.data
    return token
  })
}

export function getUserPermissions (userId) {
  return request({
    method: 'get',
    url: 'v1/system/user/' + userId + '/permissions'
  }).then(response => {
    var permissions = response.data
    return permissions
  })
}

export function getUserInfo (userId) {
  return axios.all([getUser(userId), getUserPermissions(userId)]).then(axios.spread(function (user, permissions) {
    return {user: user, permissions: permissions}
  }))
}
