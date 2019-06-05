import {searchService} from "../../services/search.service";

const state = {
  results: null,
  status: {}
};


const actions = {
  search({ commit }, query) {
    commit("SEARCH_REQUEST");

    searchService.search(query)
        .then(results => {
          commit("SEARCH_SUCCESS", results);
        }).catch(error => {
          commit("SEARCH_FAILURE");
    });
  }
};

const mutations = {
  SEARCH_REQUEST: state => {
    state.results = null;
    state.status = {loading: true};
  },

  SEARCH_SUCCESS: (state, results) => {
    state.status = { loaded: true };
    state.results = results;
  },

  SEARCH_FAILURE: state => {
    state.results = null;
    state.status = { failed: true };
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};