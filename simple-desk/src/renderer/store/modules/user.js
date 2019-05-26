import {getUserId, setUserId} from '../session'

const state = {
  id: getUserId(),
  name: '',
  realName: '',
  permissions: []
}

const getters = {
  id: state => state.id,
  name: state => state.name,
  realName: state => state.realName,
  permissions: state => state.permissions
}

const mutations = {
  SET_ID (state, id) {
    state.id = id
    setUserId(id)
  },
  SET_NAME (state, name) {
    state.name = name
  },
  SET_REAL_NAME (state, realName) {
    state.realName = realName
  },
  SET_PERMISSIONS (state, permissions) {
    state.permissions = permissions
  }
}

const actions = {
  saveUserInfos ({ commit }, {user, permissions}) {
    return new Promise((resolve) => {
      commit('SET_ID', user.userId)
      commit('SET_NAME', user.name)
      commit('SET_REAL_NAME', user.realName)
      commit('SET_PERMISSIONS', permissions)
      resolve()
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
