import {vehicleService} from "../../services";
import { router } from '../../router';

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
    },

    updateVehicleInformation({ commit, dispatch }, { registrationID, vehicleInformation }) {
        vehicleService.updateVehicleInformation(vehicleInformation).then(resp => {

            dispatch(
                "setNotice",
                { message: "Succesfully updated vehicle information." },
                { root: true }
            );

            router.push({ name: 'cars#show', params: { license_number: registrationID } });
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