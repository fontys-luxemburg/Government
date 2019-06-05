import { trackerService } from "../../services";

const state = {
    all: [],
    status: {},
    transfer_status: {}
  };

const actions = {
    getTrackers({ commit }, vehicleID) {
      commit("TRACKERS_REQUEST");
  
      trackerService
        .findTrackers(vehicleID)
        .then(trackers => {
          commit("TRACKERS_SUCCESS", trackers);
        })
        .catch(() => {
          commit("TRACKERS_FAILURE");
        });
    },

    getTripsBetweenDates({ commit }, vehicleID) {
      commit("TRIPS_REQUEST");

      trackerService
      .findTripsBetweenDates(vehicleID)
      .then(trips => {
        commit("TRIPS_SUCCESS", trips);
      }).catch(() => {
        commit("TRIPS_FAILURE");
      })
    },

    createTracker({ commit, dispatch }, vehicleID) {
      trackerService.createTracker(vehicleID).then(() => {
          dispatch("getTrackers", vehicleID);
          dispatch(
              "setNotice",
              { message: "Succesfully transfered ownership." },
              { root: true }
          );
      });
    }
};

const mutations = {
    TRACKERS_REQUEST: state => {
      state.all = [];
      state.status = { loading: true };
    },
  
    TRACKERS_SUCCESS: (state, trackers) => {
      state.status = { loaded: true };
      state.all = trackers;
    },
  
    TRACKERS_FAILURE: state => {
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