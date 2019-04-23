const state = {
  notice: null
};

const actions = {
  setNotice({ commit }, notice) {
    commit("NOTICE_SET", notice);

    setTimeout(function() {
      commit("NOTICE_REMOVE");
    }, 3000);
  }
};

const mutations = {
  NOTICE_SET: (state, notice) => {
    state.notice = notice;
  },

  NOTICE_REMOVE: state => {
    state.notice = null;
  }
}

export default {
  state,
  actions,
  mutations
}
