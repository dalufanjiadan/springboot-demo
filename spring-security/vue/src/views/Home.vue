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
            

            console.log("==========================")
            console.log(this.$store.state.user.name)
            console.log(this.$store.state.user.name===null)
            console.log("==========================")

            
        }
    }
};
</script>
