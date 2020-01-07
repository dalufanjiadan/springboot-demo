import Vue from "vue";
// import Vue from 'vue/dist/vue.js'
import App from "./App.vue";
import router from "./router";
import store from "./store";

import Buefy from "buefy";
import "buefy/dist/buefy.css";

import axios from "axios";
import VueAxios from "vue-axios";
import Axios from "./utils/httpUtil";

import Viser from "viser-vue";

import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserSecret, faAd, faSearch } from "@fortawesome/free-solid-svg-icons";
import { faFontAwesome } from "@fortawesome/free-brands-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

import {
    faCheck,
    faCheckCircle,
    faInfoCircle,
    faExclamationTriangle,
    faExclamationCircle,
    faArrowUp,
    faAngleRight,
    faAngleLeft,
    faAngleDown,
    faEye,
    faEyeSlash,
    faCaretDown,
    faCaretUp,
    faUpload,
    // faAccount,
    faHome
} from "@fortawesome/free-solid-svg-icons";

library.add(
    faCheck,
    faCheckCircle,
    faInfoCircle,
    faExclamationTriangle,
    faExclamationCircle,
    faArrowUp,
    faAngleRight,
    faAngleLeft,
    faAngleDown,
    faEye,
    faEyeSlash,
    faCaretDown,
    faCaretUp,
    faUpload,
    faFontAwesome,
    // faAccount,
    faHome,
    faSearch
);

import VeLine from "v-charts/lib/line.common";

library.add(faUserSecret, faAd, faFontAwesome);
// Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.component("vue-fontawesome", FontAwesomeIcon);
Vue.component(VeLine.name, VeLine);

Vue.use(Buefy, {
    defaultIconComponent: "vue-fontawesome",
    defaultIconPack: "fas"
});

Vue.use(VueAxios, axios);
Vue.use(Axios);
Vue.use(Viser);

import G2 from "@antv/g2";
Vue.use(G2);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount("#app");
