<template>
    <div class="home">
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
            this.axios
                .get("http://localhost:8090/api/test/hello")
                .then(response => {
                    console.log(response);
                });
        }
    }
};
</script>
