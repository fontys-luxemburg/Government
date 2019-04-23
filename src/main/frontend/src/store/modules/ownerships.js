import { ownershipsService } from "../../services";

const state = {
  all: [],
  status: {},
  transfer_status: {}
};

const actions = {
  getOwnerships({ commit }, registrationID) {
    commit("OWNERSHIPS_REQUEST");

    ownershipsService
      .findOwnerships(registrationID)
      .then(ownerships => {
        commit("OWNERSHIPS_SUCCESS", ownerships);
      })
      .catch(() => {
        commit("OWNERSHIPS_FAILURE");
      });
  },

  transfer({ commit, dispatch }, { registrationID, userID }) {
    commit("TRANSFER_REQUEST");

    ownershipsService
      .transfer(registrationID, userID)
      .then(() => {
        commit("TRANSFER_SUCCESS");
        dispatch("getOwnerships", registrationID);
      })
      .catch(() => {
        commit("TRANSFER_FAILURE");
      });
  }
};

const mutations = {
  OWNERSHIPS_REQUEST: state => {
    state.all = [];
    state.status = { loading: true };
  },

  OWNERSHIPS_SUCCESS: (state, ownerships) => {
    state.status = { loaded: true };
    state.all = ownerships;
  },

  OWNERSHIPS_FAILURE: state => {
    state.value = null;
    state.status = { failed: true };
  },

  TRANSFER_REQUEST: state => {
    state.transfer_status = { loading: true };
  },

  TRANSFER_SUCCESS: state => {
    state.transfer_status = { loaded: true };
  },

  TRANSFER_FAILURE: state => {
    state.transfer_status = {};
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
