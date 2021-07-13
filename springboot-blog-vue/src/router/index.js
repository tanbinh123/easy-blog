import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Login from '@/views/admin/Login'
import Management from '@/views/admin/Management'
import ViewBlog from '@/views/components/ViewBlog'
import EditBlog from '@/views/admin/components/EditBlog'

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
    },
    {
      path: '/viewBlog',
      name: 'ViewBlog',
      component: ViewBlog
    },
    {
      path: '/editBlog',
      name: 'EditBlog',
      component: EditBlog
    }
  ]
})
