import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login/Login'
import Home from '@/views/home/Home'
import store from '@/store'

Vue.use(Router)

const routers = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/home',
    component: Home
  }
]

const router = new Router({
  mode: 'history',
  routes: routers
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    store.dispatch('auth/tokenClear')
    next()
  } else {
    var token = store.getters['auth/token']
    if (token) {
      var permissions = store.getters['user/permissions']
      if (permissions.length === 0) {
        store.dispatch('user/loadUserInfos')
      }
      next()
    } else {
      // not login
      next('/login')
    }
  }
})

export default router
