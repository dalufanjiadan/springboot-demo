<template>
    <div id="app">
        <!-- <div id="nav">
            <router-link to="/">Home</router-link> | 
            <router-link to="/about">About</router-link> |
            <router-link to="/signin">Sign in</router-link> |
            <router-link to="/signup">Sign up</router-link> |
            <router-link to="/admin">Admin</router-link>
        </div> -->

        <b-navbar class="navbar docs-navbar is-spaced has-shadow">
            <template slot="brand">
                <b-navbar-item tag="router-link" :to="{ path: '/' }">
                    <img
                        src="https://raw.githubusercontent.com/buefy/buefy/dev/static/img/buefy-logo.png"
                        alt="Lightweight UI components for Vue.js based on Bulma"
                    />
                </b-navbar-item>
            </template>
            <template slot="start">
                <b-navbar-item href="/#/">
                    Home
                </b-navbar-item>
                <b-navbar-item href="/#/">
                    Documentation
                </b-navbar-item>
                <b-navbar-dropdown label="Info">
                    <b-navbar-item href="/#/about">
                        About
                    </b-navbar-item>
                    <b-navbar-item href="/#/contact">
                        Contact
                    </b-navbar-item>
                </b-navbar-dropdown>
            </template>

            <template slot="end">
                <b-navbar-item tag="div">
                    <div class="buttons">
                        <a class="button is-primary" href="/#/signup">
                            <strong>Sign up</strong>
                        </a>
                        <a class="button is-light" href="/#/signin">
                            Log in
                        </a>
                    </div>
                </b-navbar-item>
                <b-navbar-dropdown label="haha">
                    <b-navbar-item href="/#/admin" v-if="true">
                        Admin
                    </b-navbar-item>
              
                    <b-navbar-item @click="signout">
                        sign out
                    </b-navbar-item>
                </b-navbar-dropdown>
            </template>
        </b-navbar>
        <router-view />
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: "",
            email: "",
            password: "",
            isErrorTagActive: false,
            errorMessage: "something is wrong~ sorry!"
        };
    },
    methods: {
        signout: function() {
            // 清除token 
            localStorage.removeItem("Authorization");
            // todo:跳转到home
            this.$router.push({ path: "/signin" });
        }
    }
};
</script>

<style>
#app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

#nav {
    padding: 30px;
}

#nav a {
    font-weight: bold;
    color: #2c3e50;
}

#nav a.router-link-exact-active {
    color: #42b983;
}
</style>
