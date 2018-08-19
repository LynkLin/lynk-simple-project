import request from '@/utils/axios'
import qs from 'qs'

export function createToken (loginRequest) {
  return request({
    method: 'post',
    url: '/v1/system/auth/',
    data: qs.stringify(loginRequest)
  }).then(response => {
    var token = response.data
    return token
  })
}

export function deleteToken (token) {
  return request({
    method: 'delete',
    url: '/v1/system/auth/',
    data: qs.stringify(token)
  })
}
