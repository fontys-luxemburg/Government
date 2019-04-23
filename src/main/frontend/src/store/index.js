import Vue from 'vue';
import Vuex from 'vuex';
import vehicles from './modules/vehicles';
import ownerships from './modules/ownerships';
import auth from './modules/auth';
import notices from './modules/notices';

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        vehicles,
        ownerships,
        auth,
        notices
    },
    strict: true
});
