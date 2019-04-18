import {ownershipsService} from "../../services";

const state = {
    all: [],
    status: {}
};

const actions = {
    getOwnerships({commit}, registrationID) {
        commit("OWNERSHIPS_REQUEST");

        ownershipsService
            .findOwnerships(registrationID)
            .then(ownerships => {
                commit("OWNERSHIPS_SUCCESS", ownerships);
            })
            .catch(() => {
                commit("OWNERSHIPS_FAILURE");
            })
    }
}

const mutations = {
    OWNERSHIPS_REQUEST: state => {
        state.all = [];
        state.status = { loading: true };
    },

    OWNERSHIPS_SUCCESS: (state, ownerships) => {
        state.status = { loaded: true };
        state.all = ownerships;
    },

    OWNERSHIPS_FAILURE: (state) => {
        state.value = null;
        state.status = { failed: true };
    }
}

export default {
    namespaced: true,
    state,
    actions,
    mutations
}