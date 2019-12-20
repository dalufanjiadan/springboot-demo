<template>
    <div class="home section">
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
            // this.axios
            //     .get("http://localhost:8090/api/test/hello")
            //     .then(response => {
            //         console.log(response);
            //     });

            this.$store.commit("increment");

            console.log(this.$store.state.count); // -> 1
            console.log(this.$store.commit("setName","aaa"))
            console.log(this.$store.name)
        }
    }
};
</script>
