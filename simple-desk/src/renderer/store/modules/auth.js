import {getToken, setToken} from '../session'

const state = {
  token: getToken()
}

const getters = {
  token: state => state.token
}

const mutations = {
  SET_TOKEN (state, token) {
    state.token = token
    setToken(token)
  }
}

const actions = {
  tokenClear ({ commit }) {
    return new Promise((resolve) => {
      commit('SET_TOKEN', '')
      resolve()
    })
  },
  createToken ({ commit }, {token, userId}) {
    return new Promise((resolve) => {
      commit('SET_TOKEN', token)
      commit('user/SET_ID', userId, {root: true})
      resolve()
    })
  },
  deleteToken ({ commit }) {
    return new Promise((resolve, reject) => {
      commit('SET_TOKEN', '')
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
