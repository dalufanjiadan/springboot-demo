<template>
    <div class="home section">
        <b-icon pack="fas" icon="arrow-up" size="is-small"> </b-icon>
        <br>
        <font-awesome-icon :icon="['fas', 'user-secret']" size="lg"/>
        <font-awesome-icon :icon="['fas', 'arrow-up']" size="lg"/>
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
