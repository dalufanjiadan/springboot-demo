<template>
    <div class="home section">
        <font-awesome-icon :icon="['fas', 'user-secret']" />
        <font-awesome-icon :icon="['fas', 'ad']" />
        <font-awesome-icon :icon="['fab', 'font-awesome']" />
        <button class="button is-primary" @click="testBtnOnClick">
            hello
        </button>
    </div>
</template>

<script>
export default {
    name: "home",
    components: {},
    methods: {
        testBtnOnClick: function() {
            this.$Axios.get("/test/hello").then(data => {
                console.log("------------");
                console.log(data);
                console.log("------------");
            });
        }
    }
};
</script>
