<template>
    <section>
        <div class="box custom-box">
            <b-field label="UsernameOrEmail" class="text-left">
                <b-input v-model="usernameOrEmail"></b-input>
            </b-field>

            <b-field label="Password" class="text-left">
                <b-input type="password" v-model="password" password-reveal> </b-input>
            </b-field>

            <button class="button is-primary" @click="testBtnOnClick">
                Sign in
            </button>
            <br />
            <hr />
            <a href="#">注册</a>
        </div>
    </section>
</template>

<script>
export default {
    name: "Login",
    data() {
        return {
            usernameOrEmail: "",
            password: ""
        };
    },
    methods: {
        testBtnOnClick: function() {
            // this.axios.get("http://localhost:8090/api/test/hello").then(response => {
            //     console.log("-=-=-");
            //     console.log(response);
            // });

            // this.axios
            //     .post("http://localhost:8090/api/auth/signin", {
            //         usernameOrEmail: "aaaaa",
            //         password: "aaaaaa"
            //     })
            //     .then(response => {
            //         console.log("-=-=-");
            //         console.log(response.data);
            //         var accessToken = response.data.accessToken;
            //         var tokenType = response.data.tokenType;
            //         localStorage.setItem("Authorization", tokenType + " " + accessToken);
            //         console.log(localStorage.getItem("Authorization"))
            //     });

            console.log(this.usernameOrEmail);
            console.log(this.password);
        }
    }
};
</script>

<style scoped>
.text-left {
    text-align: left;
}

.text-right {
    text-align: right;
}

.custom-box {
    width: 300px;
    margin: 10% auto;
}
</style>
