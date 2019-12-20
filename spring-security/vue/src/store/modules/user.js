const state = {
    name: null,
    username: null,
    signin: false,
    isAdmin: false
};

const getters = {};

const actions = {};

const mutations = {
    setName(state, name) {
        state.name = name;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
};
