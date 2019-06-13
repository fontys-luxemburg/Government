import Vue from 'vue';
import App from './App.vue';
import { router } from './router';
import store from './store';
import { Laue } from 'laue';

import VueMoment from 'vue-moment';
import vSelect from 'vue-select';

import '@/assets/css/tailwind.css'
import 'vue-select/dist/vue-select.css';

Vue.config.productionTip = false;

Vue.use(VueMoment);
Vue.use(Laue);

Vue.component('v-select', vSelect);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
