<template>
    <div class="section">
        <h1>hello world</h1>
        <h1>hello world</h1>
        <h1>hello world</h1>
        <a :href="`${publicPath}html/test.html`">href</a>
        <pre>

            sdfa
            dsfa
            sdfa
        </pre>
        <pre>
            <Prism language="css">
                let i =10;
            </Prism>

             <Prism language="js">
let i =10;
let i =10;
let i =10;
            </Prism>
        </pre>
    </div>
</template>

<script>
import "prismjs/prism";
import "prismjs/themes/prism.css";
import Prism from "vue-prism-component";

export default {
    data() {
        return {
            publicPath: process.env.BASE_URL
        };
    },
    components: {
        Prism
    },
    methods: {
        onTestBtn: function() {
            console.log("hello world");
            let hello = "hello";
        }
    }
};
</script>

<style>
.number {
}
</style>
