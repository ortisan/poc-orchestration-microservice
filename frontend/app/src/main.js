import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vuelidate from 'vuelidate'
import KeenUI from 'keen-ui'
import 'keen-ui/dist/keen-ui.css'

import ApiService from './common/api.service'

Vue.use(Vuelidate)
Vue.use(KeenUI)

ApiService.init()

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App)
}).$mount('#app')
