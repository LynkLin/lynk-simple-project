import {getToken, setToken} from '@/utils/session'
import {createToken, deleteToken} from '@/api/auth'

const auth = {
  namespaced: true,
  state: {
    token: getToken()
  },
  getters: {
    token: state => state.token
  },
  mutations: {
    setToken (state, token) {
      state.token = token
      setToken(token)
    }
  },
  actions: {
    tokenClear ({ commit }) {
      return new Promise((resolve) => {
        commit('setToken', '')
        resolve()
      })
    },
    createToken ({ commit }, loginRequest) {
      return new Promise((resolve, reject) => {
        createToken(loginRequest).then(response => {
          commit('setToken', response.token)
          commit('user/setId', response.userId, {root: true})
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    deleteToken ({ commit }, token) {
      return new Promise((resolve, reject) => {
        deleteToken(token).then(() => {
          commit('setToken', '')
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default auth
