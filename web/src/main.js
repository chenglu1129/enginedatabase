/* eslint-disable */
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css'
//import echarts from 'echarts'
// import * as echarts from 'echarts'
import * as http from './requests/index'
import api from './requests/api'
Vue.prototype.$http = http
Vue.prototype.$api = api
import dataV from '@jiaminghi/data-view'


// Vue.prototype.$echarts = echarts


Vue.use(ElementUI)
Vue.use(dataV)
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
