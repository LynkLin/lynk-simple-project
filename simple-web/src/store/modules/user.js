import {getUserId, setUserId} from '@/utils/session'
import {getUserInfo} from '@/api/user'

const user = {
  namespaced: true,
  state: {
    id: '',
    name: '',
    realName: '',
    permissions: []
  },
  getters: {
    id: state => state.id,
    name: state => state.name,
    realName: state => state.realName,
    permissions: state => state.permissions
  },
  mutations: {
    setId (state, id) {
      state.id = id
      setUserId(id)
    },
    setName (state, name) {
      state.name = name
    },
    setRealName (state, realName) {
      state.realName = realName
    },
    setPermissions (state, permissions) {
      state.permissions = permissions
    }
  },
  actions: {
    loadUserInfos ({ commit }) {
      return new Promise((resolve) => {
        var userId = getUserId()
        commit('setId', userId)
        getUserInfo(userId).then(userInfo => {
          commit('setName', userInfo.user.name)
          commit('setRealName', userInfo.user.realName)
          commit('setPermissions', userInfo.permissions)
        })
        resolve()
      })
    }
  }
}

export default user
