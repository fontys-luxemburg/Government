import { vehicleService } from "../../services";
import {router} from "../../router";

const state = {
  value: null,
  status: {}
};

const actions = {
  getVehicle({ commit }, registrationID) {
    commit("VEHICLE_REQUEST");

    vehicleService
      .findVehicle(registrationID)
      .then(vehicle => {
        commit("VEHICLE_SUCCESS", vehicle);
      })
      .catch(error => {
        commit("VEHICLE_FAILURE");
      });
  },

  saveVehicle({ commit, dispatch }, params) {
    commit("CREATE_VEHICLE_REQUEST");

    vehicleService.saveVehicle(params)
        .then(vehicle => {
          commit("CREATE_VEHICLE_SUCCESS", vehicle);

          dispatch(
              "setNotice",
              { message: "Succesfully registered new vehicle" },
              { root: true }
          );

          router.push({ name: 'vehicles#show', params: { license_number: vehicle.registrationID } });
        }).catch(error => {
           commit("CREATE_VEHICLE_FAILURE");
        });
  }
};

const mutations = {
  VEHICLE_REQUEST: state => {
    state.value = null;
    state.status = { loading: true };
  },

  VEHICLE_SUCCESS: (state, vehicle) => {
    state.status = { loaded: true };
    state.value = vehicle;
  },

  VEHICLE_FAILURE: state => {
    state.value = null;
    state.status = { failed: true };
  },

  CREATE_VEHICLE_REQUEST: state => {
    state.value = null;
    state.status = { loading: true };
  },

  CREATE_VEHICLE_SUCCESS: (state, vehicle) => {
    state.value = vehicle;
    state.status = { loaded: true };
  },

  CREATE_VEHICLE_FAILURE: state => {
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
