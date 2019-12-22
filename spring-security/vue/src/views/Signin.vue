<template>
    <section class="section">
        <div class="box custom-box">
            <b-field label="UsernameOrEmail" class="text-left">
                <b-input v-model="usernameOrEmail"></b-input>
            </b-field>

            <b-field label="Password" class="text-left">
                <b-input type="password" v-model="password" password-reveal> </b-input>
            </b-field>

            <button class="button is-primary" @click="loginBtnOnClick">
                Sign in
            </button>
            <div class="field">
                <b-tag
                    v-if="isErrorTagActive"
                    type="is-warning"
                    closable
                    aria-close-label="Close tag"
                    @close="isErrorTagActive = false"
                >
                    {{ errorMessage }}
                </b-tag>
            </div>
            <hr />
            <router-link to="/signup">Sign up</router-link>
        </div>
    </section>
</template>

<script>
export default {
    data() {
        return {
            usernameOrEmail: "",
            password: "",
            isErrorTagActive: false,
            errorMessage: "something is wrong~ sorry!"
        };
    },
    methods: {
        loginBtnOnClick: function() {
            // 检查用户名密码是否为空
            if (this.usernameOrEmail.length === 0 || this.password.length === 0) {
                this.isErrorTagActive = true;
                this.errorMessage = "Incorrect username or password.";
                return;
            }

            this.$Axios
                .post("/api/auth/signin", {
                    usernameOrEmail: this.usernameOrEmail,
                    password: this.password
                })
                .then(response => {

                    console.log(response)
                    console.log(response.status)
                    if (response) {
                        
                    }

                    
                    var accessToken = response.data.accessToken;
                    var tokenType = response.data.tokenType;
                    localStorage.setItem("Authorization", tokenType + " " + accessToken);

                    // 获取设置用户信息
                    this.$Axios.get("/api/user/me").then(response => {
                        this.$store.commit("user/set", response.data);
                    });

                    // todo:跳转到home
                    this.$router.push({ path: "/" });
                })
                .catch(error => {
                    this.errorMessage = "Incorrect username or password.";
                    this.isErrorTagActive = true;
                    console.log("-=-=")
                });
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
