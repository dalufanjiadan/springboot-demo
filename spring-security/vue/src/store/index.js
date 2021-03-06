import Vue from "vue";
import Vuex from "vuex";

import user from "./modules/user"

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        count: 0
    },
    mutations: {
        increment(state) {
            state.count++;
        }
    },
    actions: {},
    modules: {
        user
    }
});
