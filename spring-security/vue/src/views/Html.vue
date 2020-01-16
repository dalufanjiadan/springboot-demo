<template>
    <div class="section">
        <h1>hello world</h1>
        <h1>hello world</h1>
        <h1>hello world</h1>
        <a :href="`${publicPath}html/test.html`">href</a>
        
    </div>
</template>

<script>
export default {
    data(){
        return {
            publicPath: process.env.BASE_URL
        }
    },
    methods: {
        onTestBtn: function() {
            console.log("hello world");
            let hello = "hello";
        }
    }
};
</script>

<style></style>
