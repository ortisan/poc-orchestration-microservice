import Vue from 'vue'
import Vuex from 'vuex'
import common from './common.module'
import auth from './auth.module'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    common,
    auth
  }
})
