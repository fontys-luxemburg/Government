import {userService} from "../../services/users.service";

const state = {
    value: null,
    status: {}
};

const actions = {
    findDriver({ commit }, driver_id) {
        commit("DRIVER_REQUEST");

        userService
            .findDriver(driver_id)
            .then(driver => {
                commit("DRIVER_SUCCESS", driver);
            })
            .catch(error => {
                commit("DRIVER_FAILURE");
            });
    }

    // save({ commit, dispatch }, params) {
    //     commit("CREATE_DRIVER_REQUEST");
    //
    //     vehicleService.saveVehicle(params)
    //         .then(driver => {
    //             commit("CREATE_DRIVER_SUCCESS", driver);
    //
    //             dispatch(
    //                 "setNotice",
    //                 { message: "Succesfully registered new driver" },
    //                 { root: true }
    //             );
    //
    //             router.push({ name: 'user#show', params: { driver_id: driver.id } });
    //         }).catch(error => {
    //         commit("CREATE_DRIVER_FAILURE");
    //     });
    // }
};

const mutations = {
    DRIVER_REQUEST: state => {
        state.value = null;
        state.status = { loading: true };
    },

    DRIVER_SUCCESS: (state, driver) => {
        state.status = { loaded: true };
        state.value = driver;
    },

    DRIVER_FAILURE: state => {
        state.value = null;
        state.status = { failed: true };
    },

    CREATE_DRIVER_REQUEST: state => {
        state.value = null;
        state.status = { loading: true };
    },

    CREATE_DRIVER_SUCCESS: (state, driver) => {
        state.value = driver;
        state.status = { loaded: true };
    },

    CREATE_DRIVER_FAILURE: state => {
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
