import Vue from 'vue';
import App from './App.vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';

import '@/assets/css/tailwind.css'

Vue.config.productionTip = false;

// Vuex state management
Vue.use(Vuex);

// Vue router
Vue.use(VueRouter);

new Vue({
  render: h => h(App),
}).$mount('#app');
