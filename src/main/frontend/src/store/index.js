import Vue from 'vue';
import Vuex from 'vuex';
import vehicles from './modules/vehicles';
import ownerships from './modules/ownerships';
import auth from './modules/auth';
import notices from './modules/notices';
import vehicleInformation from './modules/vehicle_information';
import trackers from "./modules/trackers";
import search from './modules/search';
import drivers from './modules/drivers'
import rates from './modules/rates';

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        vehicles,
        drivers,
        ownerships,
        auth,
        notices,
        vehicleInformation,
        trackers,
        search,
        rates
    },
    strict: true
});
