import {ratesService} from "../../services/rates.service";

const state = {
  all: [],
  selected: null,
  status: {}
};

const actions = {
  getRates({ commit }) {
    commit("RATES_REQUEST");

    ratesService.getAllRates().then(rates => {
      commit("RATES_SUCCESS", rates);
    }).catch(() => {
      commit("RATES_FAILURE");
    });
  },

  createRate({ commit, dispatch }, rate) {
    ratesService.createRate(rate).then(() =>{

        dispatch("getRates");
        dispatch(
            "setNotice",
            { message: "Succesfully created rate" },
            { root: true }
        );
      }
    )
  },

  createRushRate({commit, dispatch}, {rushRate, rateId}) {
    ratesService.createRushRate(rushRate, rateId).then(() => {
      dispatch("getRates");
      dispatch(
          "setNotice",
          { message: "Succesfully created deviation" },
          { root: true }
      );
    });
  }
};

const mutations = {
  RATES_REQUEST: state => {
    state.all = [];
    state.status = { loading: true };
  },

  RATES_SUCCESS: (state, rates) => {
    state.all = rates;
    state.selected = rates[0];
    state.status = { loaded: true };
  },

  RATES_FAILURE: state => {
    state.all = null;
    state.status = { failed: true };
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};