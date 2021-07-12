import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Login from '@/views/admin/Login'
import Management from '@/views/admin/Management'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/admin',
      name: 'Login',
      component: Login
    },
    {
      path: '/management',
      name: 'Management',
      component: Management
    }
  ]
})
