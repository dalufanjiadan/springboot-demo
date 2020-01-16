<template>
    <div class="section">
        <h1>hello world</h1>
        <h1>hello world</h1>
        <h1>hello world</h1>
        <a :href="`${publicPath}html/test.html`">href</a>
        <pre>

            <Prism language="java">
                int i =10;
            </Prism>
        </pre>
        <pre>
            

             <Prism language="js">
let i = 10;
let i = 10;
let i = 10;
            </Prism>
        </pre>
    </div>
</template>

<script>
import "prismjs/prism";
import "prismjs/themes/prism.css";
import "prismjs/components/prism-java";
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
    padding: 0%;
    margin: 0%;
    min-height: auto;
    height: auto;
    min-width: auto;

    width: auto;
    line-height: 1.5;
    /* background-color: aquamarine; */
    font-size: 1em;
}
</style>
