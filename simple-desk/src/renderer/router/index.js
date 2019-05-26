import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/page/login/Login'
import Home from '@/page/home/Home'
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
    path: '/home',
    name: 'home',
    component: Home
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
      console.log('321 ' + permissions)
      if (permissions.length === 0) {
        user.getUserPermissions(userId).then((user, permissions) => {
          console.log('1 ' + user)
          console.log('2 ' + permissions)
          store.dispatch('user/saveUserInfos', {user, permissions})
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
