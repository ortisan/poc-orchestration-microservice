import Vue from 'vue'
import VueRouter from 'vue-router'
import Register from '../components/Register.vue'
import Success from '../components/Success.vue'

Vue.use(VueRouter)

const routes = [
  {
    name: 'register',
    path: '/',
    component: Register
  },
  {
    name: 'success',
    path: '/success',
    component: Success
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
