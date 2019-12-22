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
            
            this.$Axios.get("/test/hello").then(
                data=>{
                    console.log("------------")
                    console.log(data)
                    console.log("------------")
                }
            )
            
        }
    }
};
</script>
