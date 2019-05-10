import {vehicleService} from "../../services";

const state = {
    value: null,
    status: {}
};

const actions = {
    getVehicleInformation({ commit }, vehicleID) {
        commit("VEHICLE_INFORMATION_REQUEST");

        vehicleService.findVehicleInformation(vehicleID).then(vehicleInformation => {
           commit("VEHICLE_INFORMATION_SUCCESS", vehicleInformation);
        }).catch(error => {
            commit("VEHICLE_INFORMATION_FAILURE");
        });
    }
};

const mutations = {
    VEHICLE_INFORMATION_REQUEST: state => {
        state.value = null;
        state.status = { loading: true };
    },

    VEHICLE_INFORMATION_SUCCESS: (state, vehicle) => {
        state.status = { loaded: true };
        state.value = vehicle;
    },

    VEHICLE_INFORMATION_FAILURE: state => {
        state.value = null;
        state.status = { failed: true };
    }
};

export default {
    namespaced: true,
    state,
    actions,
    mutations
};