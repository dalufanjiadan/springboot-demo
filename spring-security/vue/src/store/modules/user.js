const state = {
    id: null,
    name: null,
    username: null,
    signin: false,
    isAdmin: false
};

const getters = {};

const actions = {};

const mutations = {
    set(state, user) {
        state.id = user.id;
        state.name = user.name;
        state.username = user.username;
        state.isAdmin = user.admin;
    },
    clear(state) {
        state.id = null;
        state.name = null;
        state.username = null;
        state.siginin = false;
        state.isAdmin = null;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
};
