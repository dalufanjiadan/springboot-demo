import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import Buefy from "buefy";
import "buefy/dist/buefy.css";

import axios from "axios";
import VueAxios from "vue-axios";
import Axios from "./utils/httpUtil";

import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserSecret, faAd } from "@fortawesome/free-solid-svg-icons";
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
    // faAccount
);

library.add(faUserSecret, faAd, faFontAwesome);
// Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.component('vue-fontawesome', FontAwesomeIcon);

Vue.use(Buefy, {
    defaultIconComponent: "vue-fontawesome",
    defaultIconPack: "fas"
});


Vue.use(VueAxios, axios);
Vue.use(Axios);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount("#app");
