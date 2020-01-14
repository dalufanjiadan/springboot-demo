import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "home",
        component: Home
    },
    {
        path: "/about",
        name: "about",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ "../views/About.vue")
    },
    {
        path: "/signin",
        name: "signin",
        component: () => import("../views/Signin.vue")
    },
    {
        path: "/signup",
        name: "signup",
        component: () => import("../views/Signup.vue")
    },
    {
        path: "/admin",
        name: "admin",
        component: () => import("../views/Admin.vue")
    },
    {
        path: "/chart",
        name: "chart",
        component: () => import("../views/Chart.vue")
    },
    {
        path: "/test",
        name: "test",
        component: () => import("../views/Test.vue")
    },
    {
        path: "/antv",
        name: "antv",
        component: () => import("../views/AntV.vue")
    },
    {
        path: "/html",
        name: "html",
        component: () => import("../views/Html.vue")
    }
];

const router = new VueRouter({
    // mode: 'history',
    routes
});

export default router;
