import Vue from 'vue';
import App from './App.vue';
import { router } from './router';
import store from './store';
import { Laue } from 'laue';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import MonthPicker from 'vue-month-picker';
import MonthPickerInput from 'vue-month-picker';

import VueMoment from 'vue-moment';
import vSelect from 'vue-select';

import '@/assets/css/tailwind.css'
import 'vue-select/dist/vue-select.css';

Vue.config.productionTip = false;

Vue.use(VueMoment);
Vue.use(Laue);
Vue.use(BootstrapVue);
Vue.use(MonthPicker);
Vue.use(MonthPickerInput);

Vue.component('v-select', vSelect);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
