import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/page/login/Login'
import Main from '@/page/main/Main'
import store from '@/store'
import user from '@/api/user.js'

Vue.use(Router)

const routers = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: Login
    // component: require('@/page/login/Login').default
  },
  {
    path: '/main',
    name: 'main',
    component: Main
  },
  {
    path: '*',
    redirect: '/'
  }
]

const router = new Router({
  // mode: 'history',
  routes: routers
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    store.dispatch('auth/tokenClear')
    next()
  } else {
    let userId = store.getters['user/id']
    let token = store.getters['auth/token']
    if (userId && token) {
      var permissions = store.getters['user/permissions']
      if (permissions.length === 0) {
        user.getUserInfo(userId).then((userInfo) => {
          store.dispatch('user/saveUserInfo', {userInfo})
        })
      }
      next()
    } else {
      // not login
      next('/login')
    }
  }
})

export default router

// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'landing-page',
//       component: require('@/components/LandingPage').default
//     },
//     {
//       path: '*',
//       redirect: '/'
//     }
//   ]
// })
