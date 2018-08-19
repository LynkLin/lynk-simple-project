const USER_ID = 'USER_ID'
const USER_TOKEN = 'USER_TOKEN'

export function getUserId () {
  return sessionStorage.getItem(USER_ID)
}

export function setUserId (userId) {
  sessionStorage.setItem(USER_ID, userId)
}

export function getToken () {
  return sessionStorage.getItem(USER_TOKEN)
}

export function setToken (userToken) {
  sessionStorage.setItem(USER_TOKEN, userToken)
}

export function removeToken () {
  sessionStorage.removeItem(USER_ID)
  sessionStorage.removeItem(USER_TOKEN)
}
