import Vue from 'vue';
import Vuex from 'vuex';
import vehicles from './modules/vehicles';
import auth from './modules/auth';

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        vehicles,
        auth
    },
    strict: true
});
