import { vehicleService } from "../../services";

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
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
