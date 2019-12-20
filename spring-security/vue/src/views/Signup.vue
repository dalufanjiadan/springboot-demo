<template>
    <section class="section">
        <div class="box custom-box">
            <b-field label="Username" class="text-left">
                <b-input v-model="username"></b-input>
            </b-field>

            <b-field label="Email" class="text-left">
                <b-input v-model="email"></b-input>
            </b-field>

            <b-field label="Password" class="text-left">
                <b-input type="password" v-model="password" password-reveal> </b-input>
            </b-field>

            <button class="button is-primary" @click="signupBtnOnClick">
                Sign up
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
        </div>
    </section>
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
        signupBtnOnClick: function() {
            // 检查用户名密码是否为空
            if (
                this.username.length === 0 ||
                this.password.length === 0 ||
                this.email.length === 0
            ) {
                this.isErrorTagActive = true;
                this.errorMessage = "无效输入";
                return;
            }

            this.axios
                .post("http://localhost:8090/api/auth/signup", {
                    username: this.username,
                    name: this.username,
                    email: this.email,
                    password: this.password
                })
                .then(response => {

                    // todo:跳转到home
                    this.$router.push({ path: "/" });
                })
                .catch(error => {
                    this.errorMessage = "无效输入";
                    this.isErrorTagActive = true;
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
